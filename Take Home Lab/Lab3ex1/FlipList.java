// CS1020 (AY2014/5 Semester 2)
// Take-home Lab3 Ex1
// Name: CHAN WEN TJUN
// Matric. No.: A0121262X
// Lab group: 7
// This program contains classes ListNode and LinkedList.
// The Client program flips the linked list according to the inputs by the use.

import java.util.*;

class ListNode {
    private ListNode nextPointer;
    private String body;
    
    public ListNode(){
        
    }
    
    public ListNode(String content) {
        body = content;  
    }
    
    public void setNextPointer(ListNode node) {
        nextPointer = node;
    }
    
    public ListNode getNextPointer() {
        return nextPointer;
    }
    
    public void setBody(String input) {
        body = input;
    }
    
    public String getBody() {
        return body;
    }
}

class LinkedList {
    private ListNode head;
    private ListNode tail;
    private int num_nodes; 
 
    public void initialiseLinkedList(int size) {
        for (int i = 0; i < size; i++) {
            char[] char_array = Character.toChars(i + 65);
            Character character = char_array[0];
            String item = Character.toString(character);
            this.addLast(item);
        }
    }
    
    public void manipulate(int startingIndex) {
        int slotInIndex = startingIndex - 1;        
		int numberOfSwaps = num_nodes - startingIndex - 1;	

		for (int i = 0; i < numberOfSwaps; i++) {
            addAfter(slotInIndex, removeLast());
            slotInIndex++;
        }
    }
    
    
    public String print() {
        ListNode ln = head;
        StringBuilder sb = new StringBuilder(ln.getBody());
        for (int i = 1; i < num_nodes; i++) {
            ln = ln.getNextPointer();
            sb = sb.append(ln.getBody());
        }
    return sb.toString();
    }

    /****** Misc Methods ********/
    
    // Pre-condition: list
    // Post-condition: one String element is added to the list, num_nodes++
    // Description: Adds a String item to the end of the list
    private void addLast(String item) {
        if (head!= null) {
            tail.setNextPointer(new ListNode(item));
            tail = tail.getNextPointer();
        } else {
            tail = new ListNode(item);
            head = tail;
        }
        num_nodes++;
    }
    
    // Pre-condition: input index < num_nodes, index >= 0
    // Post-condition: returns a ListNode object at the input index
    // Description: Find and return the node at the given index
    private ListNode getNode(int index) {
        ListNode ln = head;
        for (int i = 0; i < index; i++) {
            ln = ln.getNextPointer();
		}
        return ln;  
    }
    
    // Pre-condition: input index < num_nodes, index >= 0
    // Post-condition: removes last node from list, num_nodes--, and returns that node
    // Description: Removes the last node from the list, and returns it
    private ListNode removeLast() {
        int index = num_nodes - 2;
        ListNode tempLast = tail;
        tail = getNode(index);
        tail.setNextPointer(null);
        num_nodes--;
        return tempLast;
    }
    
    // pre-condition: index < num_nodes, index >= 0, node != null
    // post-condition: input node is added at the index after the input index in the list, num_nodes++
    // Description: Adds a node after the node at the input index
    private void addAfter(int index, ListNode node) {
        ListNode current = getNode(index);
     
        if (current != null) {
            node.setNextPointer(current.getNextPointer());
            current.setNextPointer(node);
            if (current == tail) 
                tail = current.getNextPointer();
        } else {
            node.setNextPointer(head);
            head = node;
            if (tail == null)
                tail = head;
        }
        num_nodes++;
    }
}

public class FlipList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList list = new LinkedList();
        
        int size = scan.nextInt();
        list.initialiseLinkedList(size);
        
        int numberOfFlips = scan.nextInt();
        for (int i = 0; i < numberOfFlips; i++) {
            list.manipulate(scan.nextInt());
        }
      
        System.out.println(list.print());
    }
}

