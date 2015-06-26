// CS1020 (AY2014/5 Semester 2)
// Take-home Lab4 Ex2
// Name: CHAN WEN TJUN 
// Matric. No.: A0121262X
// Lab group: 7
// This Program reads the initial number of customers in the queue and the names
// of the customers. Then, the program reads the number of new customers and 
// the names of the customers(with the customer type) joining the queue. It 
// will then print out the sequence of customers in the queue. The program then
// reads another input of the name of the existing customers in the queue and
// prints out the number of customers in front of him/her in the queue.

import java.util.*;

public class QueueSimulation {
	Node head;
	Node tail;
	Node vipHead;
	Node vipTail;
	Node regularHead;
	Node regularTail;
	int size;

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		QueueSimulation queue = new QueueSimulation();
		int numCustomers = sc.nextInt();
		
		//Checks for existing queue
		if (numCustomers > 0) {
			sc.nextLine();

			for (int i = 0; i < numCustomers; i++) {
				queue.insert(0, sc.nextLine());
			}

			numCustomers = sc.nextInt();

			for (int j = 0; j < numCustomers; j++) {
				String type = sc.next();
				if (type.equals("VIP")) {
					queue.insert(1, sc.next());
				} else {
					queue.insert(0, sc.next());
				}
			}
		}
		
		// if there is no one is in the initial queue
		else {
			numCustomers = sc.nextInt();
			sc.nextLine();

			for (int k = 0; k < numCustomers; k++) {
				String type = sc.next();

				if (type.equals("VIP")) {
					queue.insert(1, sc.next());
				} else {
					queue.insert(0, sc.next());
				}
			}
		}
		queue.printQueue();
		queue.printSearchUser(sc.next());
	}

	//Default constructor
	public QueueSimulation() {
		
	}


	/*
	   Method Description: Adds customer(name) into queue based on priority
	   Post Cond: Adds customer into the queue based on priority
	   Pre Cond: name(data) must be a string, type(priority) must be 1 or 0
	 */
	//implement this insert function to add a person who is differentiated by type vip/regular to the queue
	public void insert(int type, String data) {
		Node customer = new Node(type, data);

		//adds first customer into empty queue
		if (size == 0) {
			head = customer;
			tail = customer;
			size++;

			if (customer.getType() == 1) {
				vipHead = customer;
				vipTail = customer;
			} else {
				regularHead = customer;
				regularTail = customer;
			}
		} else if (customer.getType() ==1) {
			// adds first VIP customer into the queue
			if (vipHead == null) {
				customer.setNext(regularHead);
				regularHead.setPrev(customer);
				vipHead = customer;
				vipTail = customer;
				head = vipHead;
				size++;
			} else {
				// adds subsequent VIP customers to the queue
				vipTail.setNext(customer);
				customer.setPrev(vipTail);
				vipTail = customer;
				vipTail.setNext(regularHead);
				regularHead.setPrev(vipTail);
				size++;
			} 
		} else {
			// adds first regular customer to the queue
			if (regularTail == null) {
				vipTail.setNext(customer);
				customer.setPrev(vipTail);
				regularHead = customer;
				regularTail = customer;
				tail = regularTail;
				size++;
			} else {
				// adds subsequent regular customers to the queue
				customer.setPrev(regularTail);
				regularTail.setNext(customer);
				regularTail = customer;
				tail = regularTail;
				size++;
			}
		}
	}

	/*
	   Method Description: Prints the queue
	   Post Cond: Prints the queue
	   Pre Cond:
	 */
	//implement this function to print the entire queue out to console
	public void printQueue() {
		Node currPerson = head;
		String queueString = "";

		for (int i = 0; i < size; i++) {
			queueString += currPerson.getData() + " ";
			currPerson = currPerson.getNext();
		}
		System.out.println("Final queue: " + 
				queueString.trim().replaceAll(" ", ", "));
	}


	/*
	   Method Description: returns number of customers ahead of a given customer in the queue
	   Post Cond: returns position of the customer from the front of the queue
	   Pre Cond: the customer must be in the queue
	 */	//implement this function to print the position of the specific user from the front
	public void printSearchUser(String searchUser) {
		int personsInFront = 0;
		Node currPerson = head;
		for (int i = 0; i < size; i++) {
			if (currPerson.getData().equals(searchUser)) {
				break;
			} else {
				personsInFront++;
				currPerson = currPerson.getNext();
			}
		}
		System.out.println("There are " + 
				personsInFront +
				" customers ahead of " + 
				searchUser);
	}

}


class Node {
	private String item; //variable which stores the name of the person in queue
	private int type; //variable to differentiate priority
	private Node prev;
	private Node next;
	//additional attributes here you think you might need


	//default constructor implement any other constructors you deem necessary
	public Node() {
		//implement any details you deem necessary	

	}
	
	public Node(int priority, String personName) {
		item = personName;
		type = priority;
	}

	public String getData() { 
		return item; 
	}

	public Node getPrev() { 
		return prev; 
	}

	public Node getNext() { 
		return next; 
	}

	public int getType() { 
		return type; 
	}

	public void setPrev(Node prevNode) { 
		prev = prevNode; 
	}

	public void setNext(Node nextNode) { 
		next = nextNode; 
	}
}

