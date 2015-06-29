import java.util.*;

/******* Class definition for ListNode *******/
class ListNode <E> {
	/* data attributes */
	private E element;
	private ListNode <E> next;

	/* constructors */
	public ListNode(E element) { 
		this(element, null); 
	}

	public ListNode(E element, ListNode <E> next) { 
		this.element = element; 
		this.next = next; 
	}

	public ListNode <E> getNext() {
		return this.next;
	}

	public E getElement() {
		return this.element;
	}

	public void setNext(ListNode <E> next) {
		this.next = next;
	}
}
/******* Class definition for MySortedLinkedList *******/
class MySortedLinkedList <E extends Comparable <E>> {

	// Data attributes
	private ListNode <E> head = null;
	private int numNodes = 0;

	// Return true if list is empty; otherwise return false.
	public boolean isEmpty() { 
		return (numNodes == 0);  // or return (head == null);
	}

	// Return number of nodes in list.
	public int size() { 
		return numNodes; 
	}

	// Return value in the first node.
	public E getFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("List is empty!");
		else 
			return head.getElement();
	}

	// Return true if list contains item, otherwise return false.
	public boolean contains(E item) {
		for (ListNode <E> curr = head; curr != null; curr = curr.getNext())
			if (curr.getElement().equals(item)) 
				return true;

		return false;
	}

	// Add item to front of list.
	public void addFirst(E item) {
		head = new ListNode <E> (item, head);
		numNodes++;
	}

	// Remove first node of list.
	public E removeFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("Can't remove from an empty list!");
		else { 
			ListNode <E> first = head;
			head = head.getNext();
			numNodes--;
			return first.getElement();
		}
	}

	// Return string representation of list.
	public String toString() {
		// Fill in the code
		ListNode <E> current = head;
		String result = "[";

		while (current != null){
			result = result + current.getElement();
			if (current.getNext()!=null) result = result + ", ";
			current = current.getNext();
		}
		return result +"]";
	}


	// Add item to the list, maintaining the order.
	public void addOrdered(E item) {
		// Fill in the code
		if (head == null) 
			addFirst(item);
		else if (head.getElement().compareTo(item)>0) 
			addFirst(item);
		else {
			ListNode <E> current = head;
			while (current != null){
				if (current.getNext() == null) {
					current.setNext(new ListNode <E>(item));
					numNodes++;
					break;
				}
				if (current.getNext().getElement().compareTo(item)>0){
					ListNode<E> temp = current.getNext();
					current.setNext(new ListNode<E>(item,temp));
					numNodes++;
					break;
				}
				current = current.getNext();
			}
		}
	}
}
