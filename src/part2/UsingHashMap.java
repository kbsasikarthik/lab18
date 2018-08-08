// @ Sasikaladevi Kumarasamy
package part2;

import java.util.Arrays;
import java.util.HashMap;

// This class finds the occurrences of a number from an array and puts the corresponding number and its occurrences in a HashMap
// Big O - O(n)
public class UsingHashMap {

	public static void main(String[] args) {
		    int[] array ={1,2,3,1,6,4,7,5,6,3,2,1};
		    System.out.println("\nInput:\n~~~~~~");
		    System.out.println("Array Elements:");
		    System.out.println(Arrays.toString(array));
			HashMap<Integer, Integer> map = new HashMap<>();

		    for(int number:array){

		        if(!map.containsKey(number)){
		            map.put(number,1); // if it is the first occurrence of a number, add it as key put 1 against its value
		        }else{
		            map.put(number, map.get(number)+1); // if the number(Key)already exist in the HashMap, then increment Value by 1
		        }
		    }
		    System.out.println("\nOutput:\n~~~~~~~");
		    System.out.println("\nHashMap Key-Value pair:");
		    System.out.println(map); // print the hashmap
	}

}
