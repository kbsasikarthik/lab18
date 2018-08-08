// Sasikaladevi Kumarasamy 
package part1;

public class ListApp {

	public static void main(String[] args) {
		MyList list = new MyLinkedList(); 
//		list = new MyArrayList(); // uncomment it to work on ArrayList
		test(list);
	}
	
	private static void test(MyList list) {
		boolean added = false, removed = false;
		list.addAtBeginning("F");
		list.addAtBeginning("D");
		list.addAtBeginning("C");
		list.addAtBeginning("B");
		list.addAtBeginning("A");
		list.addAtBeginning("C");
		list.addAtBeginning("B");
		list.addAtBeginning("A");		
		list.addAtBeginning("C");
		list.addAtBeginning("B");
		list.addAtBeginning("A");

		list.addAtEnd("Y");
		list.addAtEnd("Z");
		System.out.println("\nBefore insert :\n" + list);

		added = list.insertAt(3, "E");// stores boolean returned by the method call
		System.out.println("\nAdded ? "+ added);
		System.out.println("\nAfter insert :\n "+ list);
		
		removed = list.removeAt(4); // stores boolean returned by the method call
		System.out.println("\nRemoved ? "+ removed);
		System.out.println("\nAfter removing :\n "+ list);
		
		list.removeAll("A");
		System.out.println("\nAfter removing all A's :\n " + list);
		System.out.println("Printing in Reverse order :\n");
		list.printReverse(); // print in reverse order

	}

}
