import java.util.*;

class Knob {

	// Data attributes
	boolean isOn = true;      // is the device on?
	String currPos;    // current position of knob
	String targetPos;  // target position of knob

	// Constructor
	public Knob(boolean state, String newCurrPos, String newTargetPos) { 
		isOn = state;
		currPos = newCurrPos;
		targetPos = newTargetPos;
	}

	// Determine whether the device is on or off after num moves
	public boolean deviceIsOn(int num) {
		if (isOn && (num % 2 == 0)) {
			return true;
		} else if (isOn && (num % 2 == 1)) {
			return false;
		} else if (!isOn && (num % 2 == 0)) {
			return false;
		} else if (!isOn && (num % 2 == 1)) {
			return true;
		} else
			return false;	// this is a stub
	}
	
	// Compute the least number of moves to turn the knob
	public int numOfMoves() {                       
		String[] arr = {"up", "right", "down", "left", "up", "right", "down", "left"};
		int movesNeeded = 0;

		if (currPos.equals(targetPos)) {
			return 4;
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (currPos.equals(arr[i])) {
					for (int j = i + 1; j < arr.length; j++) {
						movesNeeded++;
						if (targetPos.equals(arr[j])) {
							return movesNeeded;
						}
					}
				}
			}
		} return movesNeeded;
	}
}

