package part1;

import java.util.Arrays;

public class MyArrayList implements MyList {
	
	String[] array = new String[4];
	private int length = 0;

	@Override
	public void addAtEnd(String data) {
		if (isFull()) {
			// If our array is out of space, double the size.
			doubleLength();
		}
		// Set the next item in the array and increment the length.
		array[length] = data;
		length++;
	}

	@Override
	public void removeFromEnd() {
		// Clear the last slot and decrement the length.
		array[length - 1] = null;
		length--;
	}

	@Override
	public void addAtBeginning(String data) {
		if (isFull()) {
			// If our array is out of space, double the size.
			doubleLength();
		}
		// Loop backwards and shift all the items over to make room for the new one.
		for (int i = length; i > 0; i--) {
			array[i] = array[i - 1];
		}
		// Set first element and increment length
		array[0] = data;
		length++;
	}

	@Override
	public void removeFromBeginning() {
//		array[0] = null;
		for (int i = 0; i < length-1; i++) {
			array[i] = array[i+1];
		}
		length--;
	}

	@Override
	public String get(int index) {
		return array[index];
	}

	@Override
	public int size() {
		return length;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		for (int i = 0; i < length; i++) {
			sb.append(array[i]);
			if (i != length - 1) {
				// Add comma, except after last item
				sb.append(", ");
			}
		}
		sb.append(" ]");
		return sb.toString();
	}
	
	private boolean isFull() {
		return length == array.length;
	}
	
	private void doubleLength() {
		// make a new copy of the array that is twice as long
		array = Arrays.copyOf(array, array.length * 2);
	}

	// the object at the given index will be removed
	// returns true if it is able to remove the object at given index else it returns false
	@Override
	public boolean removeAt(int index) {
		if(index >= 0 && index < length) {
			array[index] = null;
		for (int i = index ; i < length-1; i++) {
			array[i] = array[i+1];
		}
		length--;
		return true;
	} else
		
		return false;
	}

	// the given object is inserted at the given index. Returns true if successful else returns false
	@Override
	public boolean insertAt(int index, String data) {
		// if the array is full, the size of it will be doubled 
		if (isFull()) {
			doubleLength();
		}
		if(index >= 0 && index <= length) {
			for (int i =length; i>index; i--) {
				array[i] = array[i - 1];
			}
			array[index] = data;
			length++;
			return true;
		}else 
			return false;
	}

	// removes all occurrences of the given object
	@Override
	public void removeAll(String data) {

		for (int i = 0 ; i <=length; i++) {
			if(array[i].equals(data)) {
				removeAt(i);
			}
		}
	}

	// loops from the end to the beginning of the ArrayList and prints each object
	@Override
	public void printReverse() {
		for(int i=length-1 ; i>=0; i--) {
			System.out.print(array[i]+", ");
		}
	}

}
