// CS1020 (AY2014/5 Semester 2)
// Take-home Lab4 Ex1
// Name: Chan Wen Tjun
// Matric. No.: A0121262X
// Lab group: 7
// This program contains the service class Container and client program CargoOptimization, which reads in
// a single line of capitalised alphabets (indicating the order of the containers to be unloaded) and returns
// the minimum number of stacks required for efficient loading later on.

import java.util.*;

public class CargoOptimization {
    
    private ArrayList<Stack<Container>> stacks; // use an array list to represent the stacks in the terminal
    public CargoOptimization() { stacks = new ArrayList<Stack<Container>>(); }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CargoOptimization optimizer = new CargoOptimization();
        
        String lineOfContainers = sc.nextLine();
        int numContainers = lineOfContainers.length();
        
        for (int i = 0; i < numContainers; i++) {
            char ship = lineOfContainers.charAt(i);
            optimizer.processContainer(ship);
        }
        
        System.out.println(optimizer.getNumOfStacks());

    }
    
    
    
    public int getNumOfStacks() { return stacks.size(); }
    
    // handles each arriving container
    public void processContainer(char ship) {
        Container container = new Container(ship);
        
        if (!this.hasPossibleStack(container)) {
            Stack newStack = new Stack();
            newStack.push(container);
            stacks.add(newStack);
        } else  {
            Stack selectedStack = stacks.get(findBestStack(container));
            selectedStack.push(container);
        }
    }
    
    // returns whether there is a possible stack already present for the container to be stored in
    private boolean hasPossibleStack(Container newArrival) {
        boolean hasStack = false;
        
        if (this.getNumOfStacks() == 0) {
            return false;
        } else {
            for (int i = 0; i < this.getNumOfStacks(); i++) {
                int score = newArrival.calculateFitWith(stacks.get(i));
                if (score >= 0) {
                    hasStack = true;
                    break;
                } else {
                }
            }
            return hasStack;
        }
    }
    
    // returns the index of the best stack to put the container in
    private int findBestStack(Container newArrival) {
        int score = 999;
        int index = 0;
        for (int i = 0; i < this.getNumOfStacks(); i++) {
            int newScore = newArrival.calculateFitWith(stacks.get(i));
            if (newScore < score && newScore >=0) {
                score = newScore;
                index = i;
            } else {
            }
        }
        return index;   
    }
}


class Container {
    private char destination;
    public Container(char destination) { this.destination = destination; }
    
    // method should return compatibility score between this container and the target stack. 
    // they are most compatible when the container at the top of the stack has the same destination as this container
    // Most compatible being 0, and compatibility decreases with the increase in score.
    // if score < 0, the container cannot be placed there at all
    public int calculateFitWith(Stack<Container> candidate) {
        Character candidateChar = Character.valueOf(candidate.peek().destination);
        Character currentChar = Character.valueOf(destination);
        int score = candidateChar.charValue() - currentChar.charValue();
        return score;   
    }
}
