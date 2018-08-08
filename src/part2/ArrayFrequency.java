// @ Sasikaladevi Kumarasamy
package part2;

// This program finds the occurrences of a number in an array and puts it in another array
public class ArrayFrequency {
	 
    public static void main(String[] args) {
    	
        int arrayOf4[] = {4, 4, 4, 4};
        findCounts(arrayOf4, arrayOf4.length);
 
        int bigArray[] = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
        findCounts(bigArray, bigArray.length);

    }

	 // method to find counts of all elements present in an array
    public static void findCounts(int array[], int n) 
    {
        int i = 0;
        while (i < n) 
        {
            // If this element is already processed,
            // then nothing to do
            if (array[i] <= 0) 
            {
                i++;
                continue;
            }
             // Find index corresponding to this element (index for 5 is 4)
            int elementIndex = array[i] - 1;
            
            // If the elementIndex has an element that is not checked yet, then that element
            // is stored in an array then it gets checked
            if (array[elementIndex] > 0) 
            {
                array[i] = array[elementIndex];
                 // After storing array[elementIndex], change it
                // to store initial count of 'array[i]'
                array[elementIndex] = -1;
            } 
            else
            {
                // If this is NOT first occurrence of array[i], then increment its count by 1.
                array[elementIndex]--;
                array[i] = 0;
                i++;
            }
        }
 
        System.out.println("\n\nCounts of all elements in the given array:");
        for (int j = 0; j < n; j++)
            System.out.print(j+1 + " -> " + Math.abs(array[j])+" , ");
    }

}
