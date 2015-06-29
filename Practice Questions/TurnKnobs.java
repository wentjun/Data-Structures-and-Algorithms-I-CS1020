// This program reads in information of a number of knobs.
// For each knob, its current state, current position and
// target position. It then computes the state of each knob after
// the required number of stops, and the total stops of all knobs.

// Add import statement(s) below
import java.util.*;
import java.util.ArrayList;

public class TurnKnobs{

	public static void main(String[] args){


		// Declare the necessary variables
 		// Read input and process them accordingly

		Scanner sc = new Scanner(System.in);

		int numberOfKnobs = sc.nextInt();
//		sc.nextLine();
		
		ArrayList<Knob> knobs = new ArrayList<Knob>();
	    
		String nextInput = "";
		for (int i = 0; i < numberOfKnobs; i++) {
			nextInput = sc.next();
			if (nextInput.equals("on")) {
				knobs.add(new Knob(true, sc.next(), sc.next()));
			} else { 
				knobs.add(new Knob(false, nextInput, sc.next()));
			}
		}	
		// Output the result
		// Use the given println() statements below to ensure that 
		// your outputs are in the right format.
		// Print result for each knob
		int move = 0;
		int[] arrMoves = new int[numberOfKnobs];

		for (int j = 0; j < numberOfKnobs; j++) {
			arrMoves[j] = knobs.get(j).numOfMoves();
			move += arrMoves[j];
		}


		for (int k = 0; k < numberOfKnobs; k++) {
			if (knobs.get(k).deviceIsOn(arrMoves[k])) {
				System.out.println("on");
			} else {
				System.out.println("off");
			}
		}

		// Print total number of stops 
		System.out.println("Total stop(s) = " + move);
	}
}

