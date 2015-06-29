// Define the Set class
import java.util.*;
import java.util.ArrayList;

class Set {

	private ArrayList<Integer> members;

	// Constructors
	public Set(ArrayList<Integer> input){
		members = input;
	}

	// toString() method
	public String toString() {
		return "[" + "," + "]";
	}

	// Return true if 'this' is a subset of 'set', 
	// otherwise return false.
	//  
	public boolean isSubset(Set set) {
		for (int i = 0; i < members.size(); i++) {
			if (!set.members.contains(members.get(i))) {
				return false;
			}
		} 
   		return true;    //this is a stub
	}
}
