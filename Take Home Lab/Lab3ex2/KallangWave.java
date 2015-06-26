// CS1020 (AY2014/5 Semester 2)
// Take-home Lab3 Ex2
// Name: CHAN WEN TJUN
// Matric. No.: A0121262X
// Lab group: 7
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Marks will be awarded for this in sit-in labs.
// This program first reads an input which is the current state of the Kalland Wave.
// The subsequent inputs from the user indicates the number of movements passed after the current Kallang Wave state.
// The elements in the input are shifted in the form of a circular linked list, and the 
// number of times the elements shift are indicated by the number of moments.

import java.util.*;

public class KallangWave {

	private CircularLinkedList<String> audience;

	public KallangWave(String audienceChars) {
		audience = new CircularLinkedList<String>();
		for (int i = audienceChars.length() - 1; i >= 0; i--)
			audience.addFirst(audienceChars.charAt(i) + "");
	}
	// Method description: shifts kallang wave moment elements to the right
	// Pre-conditions: the audience object is a circular linked list 
	// Post-conditions: sets the head to the new position as if the elements were shifted
	private void simulateWave(int moments) {
		audience.setHead(moments);
	}
	// Method description:prints the movement of the kallang wave at the given moment
	// Pre-conditions:audience object needs to be initialized
	// Post-conditions:prints the object as string
	private void printState() {
		System.out.println(audience.toString());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		KallangWave kallangWave = new KallangWave(sc.nextLine());
		while (sc.hasNext()) {
			kallangWave.simulateWave(sc.nextInt());
			sc.nextLine();
			kallangWave.printState();
		}
		sc.close();
	}

	class ListNode <E> {

		private E element;
		private ListNode <E> next;

		public ListNode(E item) {
			this(item, null);
		}

		public ListNode(E item, ListNode <E> next) {
			element = item;
			this.next = next;
		}

		public ListNode <E> getNext() {
			return next;
		}

		public E getElement() {
			return element;
		}

		public void setNext(ListNode <E> next) {
			this.next = next;
		}
	}

	class CircularLinkedList <E> {

		private ListNode <E> head = null;
		private int numNodes = 0;

		// Method description: Returns whether this linked list has no nodes.
		public boolean isEmpty() {
			return (numNodes == 0);
		}

		// Method description: Returns the number of nodes in this linked list.
		public int size() {
			return numNodes;
		}

		// Method description: returns first object of the list
		// Pre-conditions: initialised the linked list
		// Post-conditions: throws exception if linked list ocntains null object.
		// if linked list ocntains objects, returns the first objext
		public E getFirst() throws NoSuchElementException {
			if (head == null) {
				throw new NoSuchElementException("Can't get from an empty list");
			} else {
				return head.getElement();
			}
		}
		// Method description: adds item at top of the list
		// Pre-conditions: linked list must be initialised
		// Post-conditions: new item will be added to the top of the list and a circular link is formed from the list
		public void addFirst(E item) {
			if (head == null) {
				head = new ListNode<E>(item);
			} else {
				head = new ListNode<E>(item, head);
			}
			numNodes++;
			circularLink();
		}

		// Method description: removes first item at the list
		// Pre-conditions: linked list must be initialized
		// Post-conditions: if the linked list contains null objects, it will throw an exception.
		//If not, it returnsa linked list with the head pointing to the subsequent
		// object of the previous head
		public E removeFirst() throws NoSuchElementException {
			if (head == null) {
				throw new NoSuchElementException("Can't remove from an empty list");
			} else {
				numNodes--;
				E temp = head.getElement();
				head = head.getNext();
				return temp;
			}
		}
		// Method description: link the last node to the head
		// Pre-condition: object must not be null
		// Post-condition: last node's next pointer points to the head
		public void circularLink() {
			ListNode<E> current = head;
			for (int i = 0; i < numNodes - 1; i++) {
				current = current.getNext();
			}
			current.setNext(head);
		}

		// Method description: sets head of the object to new position after moments have passed
		// Pre-condition: object must not be null
		// Post-condition: Head is moved to the respective moment's position.
		public void setHead(int numElements) {
			for (int i = 0; i < numNodes - (numElements % numNodes); i++) {
				head = head.getNext();
			}
		}

		// Whenever overriding a function, it is good practice to prefix it with @Override.
		// Feel free to remove these two lines. Wouldn't want any unnecessary comments to get in the way of your marks.
		// Method description: prints Kallang Wave
		// Pre-conditions: Linked list initialized.
		// Post-conditions:String containing kallang wave will be printed
		@Override
		public String toString() {
			String result = "";
			ListNode<E> current = head;
			int numElements = numNodes;
			while (numElements-->0){
				result = result + current.getElement();
				current = current.getNext();
			}
			return result;
		}
	}
}
