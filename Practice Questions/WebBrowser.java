/*  
 * Description of program: This program simulates the web browser with the forward
 * and back buttons on the web browser. The button retrieves information from the
 * web browser history.
 */ 

import java.util.*;

/* WebBrowser Simulator */
public class WebBrowser {
	Stack<String> forward;
	Stack<String> back;
	String current = null;

	public WebBrowser(Scanner sc) {
		forward = new Stack<String>();
		back = new Stack<String>();

		String command;	
		while(sc.hasNextLine()){
			command = sc.nextLine();

			if(command.equals("BACKWARD")){
				if(!back.empty()){
					forward.push(current);
					current = back.pop();
				}
			}
			else if(command.equals("FORWARD")){
				if(!forward.empty()){
					back.push(current);
					current = forward.pop();
				}
			}
			else{
				if(current != null) back.push(current);
				current = command;
				//remove all the forward history
				forward = new Stack<String>();
			}
		}
	}
	//remove the top browser in the forward stack
	public String setForward(){
		if(forward.empty())
			return null;

		return forward.pop();
	}
	// remove the top browser in the backward stack
	public String setBack(){
		if(back.empty())
			return null;
		return back.pop();
	}

	public void printHistory(){
		String backBrowser = "";
		
		if(back.empty() && forward.empty()){
			System.out.println("Browsing history is empty.");
		}
		else{
			System.out.println("Browsing History:");

			while(! back.empty())
				backBrowser = back.pop()+ "\n" + backBrowser;

			System.out.print(backBrowser);
			System.out.println(current);

			while(!forward.empty())
				System.out.println(forward.pop());

			System.out.println("Current Page:");
			System.out.println(current);
		}
	}

	public static void main(String[] args) {         
		Scanner sc = new Scanner(System.in);     
		WebBrowser bc = new WebBrowser(sc);

		bc.printHistory();
	}
}
