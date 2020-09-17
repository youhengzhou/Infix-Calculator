import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import static javafx.scene.input.KeyCode.T;

public class InfixCalculator {
    
	// get index of smallest element
	public static <T extends Comparable<? super T>> int leastIndex( T[] theArray , int p, int n){
		// if the current element is the required element
		int i =0;
		if( p == n )
			return i;
	   
		// recursively find the index of the smallest element in right subarray
		int min_index = leastIndex(theArray, p + 1, n);
	   
		// return the index of the smaller of the p th and the k th element
		return theArray[p].compareTo(theArray[min_index]) < 0 ? p : min_index;
	}

	public static <T extends Comparable<? super T>> void recursiveSelectionSort( T[] theArray, int n ){
		recursiveSelectionSortUtil(theArray, n, 0);
	}

	public static <T extends Comparable<? super T>> void recursiveSelectionSortUtil( T[] theArray, int n, int x ){
		// if the array is sorted
		if( x == n )
			return;
	   
		// find the minimum element index in subarray theArray[ x, n - 1 ]
		int min_index = leastIndex(theArray, x, n - 1);
	   
		// swap the two elements
		if( min_index != x )
		{
			int k = 0;
			T temp = theArray[k];
			theArray[min_index] = theArray[x];
			theArray[x] = temp;
		}
	   
		recursiveSelectionSortUtil(theArray, n, x + 1);
	}
	public static <T extends Comparable<? super T>> void recursiveBubbleSort( T[] theArray, int n ){
		// array of size 1 is already sorted
		if( n == 1 )
			return;
	   
		int i;
	   
		for( i = 0 ; i < n - 1 ; i++ )
		{
		   
			if( arr[i] > arr[i + 1] )
			{
				T temp = theArray[i];
				theArray[i] = theArray[i + 1];
				theArray[i + 1] = temp;
			}
		}
	   
		recursiveBubbleSort( theArray, n - 1 );
	}
	  
		
		public static boolean isInLanguage (String str){
				Stack<Character> stack = new Stack<>();
			for(int i = 0; i < str.length(); ++i) {
				stack.push(str.charAt(i));
			}
			for(int i = 0; i < str.length(); ++i) {
				if(str.charAt(i) != stack.pop()) {
					return false;
				}
			}
			return true;
		}
		
	 public static int convertToNumber(String str){
	  int result = 0;
	  try {
		Queue<Character> queue = new LinkedList<>();
		for (char ch : str.toCharArray()) {
		  if (ch != ' ') {
			queue.add(ch);
		  }
		}
		while (!queue.isEmpty()) {
		  result = result * 10;
		  result += queue.poll() - '0';
		}
	  }
	  catch (Exception e){
		System.out.println("Exception occurred...");
	  }
	  return result;
	}
		 

		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = in.nextLine();
		if (isInLanguage(str)) {
			System.out.println("word \"" + str + "\" is a word of the L language");
		} else {
			System.out.println("word \"" + str + "\" is NOT a word of the L language");
		}

	 }
}

