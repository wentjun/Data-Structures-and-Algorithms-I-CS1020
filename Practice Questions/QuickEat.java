
// This program helps staff manage customers'
// orders and decide who should be given a ready dish.

import java.util.*;

// This class represents all orders of customers
class ListOrder {
    
    // Data member
    private int numDishes;
    // All dishes which the restaurant offers
    private String[] dishes;
    // Each dish has a queue of customers who ordered this dish
	// All such queues are put inside an ArrayList called dishQueues
    private ArrayList<Queue<Integer>> dishQueues;
    
    // Constructor
    public ListOrder(int numDishes, Scanner sc) {
		this.numDishes = numDishes;
		dishes = new String[numDishes];
		dishQueues = new ArrayList<Queue<Integer>>();
		
		for(int i=0; i< numDishes ; i++){
			dishes[i] = sc.nextLine();
			dishQueues.add(new LinkedList<Integer>());
		}
    }
    
    // Add new order to the list
    public void addNewOrder(int dishID, int tag) {
       dishQueues.get(dishID-1).offer(tag); 
    }
    
    // Process food when it is ready
    // Return the customer who currently ordered for the dish
    // if there is no customer order for this dish return -1
    public int processReadyFood(int dishID) {
		if(dishQueues.get(dishID-1).peek() == null)
			return -1;
		return dishQueues.get(dishID-1).poll();// stub
    }

    // Get dish's name
    public String getDishName(int dishID) {

		return dishes[dishID-1]; // stub
    }

}

public class QuickEat {

    public static void main(String [] args) {
        
        Scanner sc = new Scanner(System.in);
        int numDishes = sc.nextInt();
        sc.nextLine();
        
        // Create the list order of food
        ListOrder listOrder = new ListOrder(numDishes, sc);
        
        int noOfCommands = sc.nextInt();
        sc.nextLine();
        
		for(int i=0; i< noOfCommands; i++){
			String command = sc.next();

			if(command.equals("Order")){
				int customerNo = sc.nextInt();
				int orderDishes = sc.nextInt();
				
				for(int j=0; j<orderDishes; j++){
					listOrder.addNewOrder(sc.nextInt(), customerNo);
				}
			}
			else{
				int dishNo = sc.nextInt();
				int custNo = listOrder.processReadyFood(dishNo);
				
				if(custNo == -1){
					System.out.println("Throw away " + listOrder.getDishName(dishNo)+ ".");
				}
				else{
					System.out.println(listOrder.getDishName(dishNo) + " ready to be served to Tag " + custNo + ".");
				}
			}
		}
        // Process commands
    }
}

