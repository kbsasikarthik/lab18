// @ Sasikaladevi Kumarasamy
package part1;

public class MyLinkedList implements MyList {

	
	// head is the first node in the list. if null, the list is empty.
	private Node head = null;
	// for convenience, keep track of how many items are in the list
	private int length = 0;
	
	@Override
	public void addAtBeginning(String data) {
		// add a new node and set it as the new head
		head = new Node(data, head);
		length++;
	}
	
	@Override
	public void removeFromBeginning() {
		// find the second node and set it as the new head
		head = head.getNext();
		length--;
	}
	
	@Override
	public void addAtEnd(String data) {
	
		Node oldLastNode = getNodeAt(length-1);
		Node newTail = new Node(data, null);
		oldLastNode.setNext(newTail);
		length++;

	}
	
	@Override
	public void removeFromEnd() {
		if (length < 2) {
			// The beginning is the end.
			removeFromBeginning();
		} else {
			// find the node right before the end.
			Node beforeTail = getNodeAt(length - 2);
			// set its next to null. This ends the list here.
			beforeTail.setNext(null);
			length--;
		}
	}
	
	@Override
	public String get(int index) {
		return getNodeAt(index).getData();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// start at the head
		Node node = head;
		// follow the links between nodes until it reaches the end 
		while (node != null) {
			sb.append(node.toString());
			node = node.getNext();
		}
		return sb.toString();
	}
	
	@Override
	public int size() {
		return length;
	}
	
	private Node getNodeAt(int index) {
		// start at the head
		Node node = head;
		// follow the links between nodes until it counts off the right number
		for (int i = 0; i < index; i++) {
			if (node == null) {
				// In case we run out of nodes before we get up to the desired index, return null
				return null;
			}
			node = node.getNext();
		}
		return node;
	}

	// the object at the given index will be removed
	// returns true if it is able to remove the object at given index else it returns false
		@Override
	public boolean removeAt(int index) {
		Node node = head;
		if(index == 0) {
			removeFromBeginning();
			return true;
		}else {
			for(int i = 0 ; i< index-1; i++) {
				node = node.getNext();
			}
			node.setNext(node.getNext().getNext());
			return true;
		}
	}

	// the given object is inserted at the given index. Returns true if successful else returns false
	@Override
	public boolean insertAt(int index, String data) {
		Node node = head;
		if(index ==0){
			addAtBeginning(data);
			return true;
		}else if(index == length) {
			addAtEnd(data);
			return true;
		} else {
			node = new Node(data, getNodeAt(index));
			getNodeAt(index-1).setNext(node);
			return true;
		}
		
	}

	// removes all occurrences of the given object
	@Override
	public void removeAll(String data) {
		Node node = head;
		while (node != null && node.getNext() != null) { //check for rest of the node except first
			if (node.getNext().getData().equals(data)) {
				node.setNext(node.getNext().getNext());
			} else {
				node = node.getNext();
			}
		}
		if (head != null && head.getData().equals(data)) { //If first node also contain the key
		head = head.getNext();
		}

	}

	// loops from the end to the beginning of the ArrayList and prints each object
	@Override
	public void printReverse()
	{
	 printReverse(head);
	}

	private void printReverse(Node node)
	{
	  if (node.getNext() != null) 
	   {
	     printReverse(node.getNext());
	   }
	  System.out.print(node.getData()+"-> ");
	}

}
