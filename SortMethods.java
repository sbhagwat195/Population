import java.util.List;
/**
 *	SortMethods - Sorts an array of Integers in ascending order.
 *
 *	@author Shashi Bhagwat
 *	@since	6 December 2022
 */
public class SortMethods {
	private City[] temp;
	
	/**
	 * Modified version of SelectionSort that sorts Cities instead of Integers
	 * by their population. If two cities have the same population, it sorts
	 * them by their name instead. This method sorts them from smallest to biggest
	 */
	public void ascendingOrderPopSelectionSort(List<City> arr)
	{
		for(int i = arr.size(); i > 0; i --)
		{
			int pointer1 = 0;
			for(int pointer2 = 1; pointer2 < i; pointer2++)
			{
				if(arr.get(pointer1).compareTo(arr.get(pointer2)) < 0)
				{
					pointer1 = pointer2;
				}
			}
			
			swap(arr, pointer1, i-1);
		}
	}
	
	/**
	 * Modified version of MergeSort that sorts Cities instead of Integers
	 * by their population. If two cities have the same population, it sorts
	 * them by their name instead. This method sorts then in descending order
	 * from biggest to smallest. The other two methods have also been modified
	 * to work with Cities instead of Integers and to sort the list from greatest
	 * to smallest rather than the opposite.
	 */
	public void descendingOrderPopMergeSort(List<City> arr)
	{
		int n = arr.size();
		temp = new City[n];
		recursiveSortDescendingPop(arr, 0, n-1);
	}
	
	public void recursiveSortDescendingPop(List<City> array, int from, int to)
	{
		if(to - from < 2)
		{
			if(to > from && array.get(to).compareTo(array.get(from)) > 0)
			{
				swap(array, to, from);				
			}
		}
		else
		{
			int middle = (from + to)/2;
			recursiveSortDescendingPop(array, from, middle);
			recursiveSortDescendingPop(array, middle + 1, to);
			mergeDescendingPop(array, from, middle, to);
		}
		
	}
	
	public void mergeDescendingPop(List<City> array, int from, int middle, int to)
	{
		int i = from;
		int j = middle+1;
		int k = from;
		
		while(i <= middle && j <= to)
		{
			if(array.get(i).compareTo(array.get(j)) > 0)
			{
				temp[k] = array.get(i);
				i++;
			}
			else
			{
				temp[k] = array.get(j);
				j++;
			}
			k++;
		}
		
		while(i <= middle)
		{
			temp[k] = array.get(i);
			i++;
			k++;
		}
		
		while(j <= to)
		{
			temp[k] = array.get(j);
			j++;
			k++;
		}
		
		for(k = from; k <= to; k++)
		{
			array.set(k,temp[k]);
		}
	}
	
	/**
	 * This method is a modified version of InsertionSort that takes in 
	 * a list of Cities instead of an array of Integers. It sorts the cities
	 * by their name in order from first to last, meaning it sorts them 
	 * so that the first one starts with a, and then b, and then c, and so on.
	 */
	public void nameInsertionSort(List<City> arr) 
	{
		for(int i = 1; i < arr.size(); i ++)
		{
			City temporary = new City(arr.get(i));
			
			int n = i;
			while(n > 0 && arr.get(n-1).compareNameTo(temporary) > 0)
			{
				swap(arr, n, n-1);
				n--;
			}
			
			arr.set(n, temporary);
		}
	}
	
	
	/**
	 * Modified version of MergeSort that sorts Cities instead of Integers
	 * by their population. The method sorts the cities in descending order
	 * by their name, meaning instead of from a to z, from z to a. The other two
	 * methods have also been modified to work with Cities instead of Integers.
	 */
	public void nameMergeSort(List<City> arr)
	{
		int n = arr.size();
		temp = new City[n];
		recursiveSortName(arr, 0, n-1);
	}
	
	public void recursiveSortName(List<City> array, int from, int to)
	{
		if(to - from < 2)
		{
			if(to > from && array.get(to).compareNameTo(array.get(from)) > 0)
			{
				swap(array, to, from);				
			}
		}
		else
		{
			int middle = (from + to)/2;
			recursiveSortName(array, from, middle);
			recursiveSortName(array, middle + 1, to);
			mergeName(array, from, middle, to);
		}
		
	}
	
	public void mergeName(List<City> array, int from, int middle, int to)
	{
		int i = from;
		int j = middle+1;
		int k = from;
		
		while(i <= middle && j <= to)
		{
			if(array.get(i).compareNameTo(array.get(j)) > 0)
			{
				temp[k] = array.get(i);
				i++;
			}
			else
			{
				temp[k] = array.get(j);
				j++;
			}
			k++;
		}
		
		while(i <= middle)
		{
			temp[k] = array.get(i);
			i++;
			k++;
		}
		
		while(j <= to)
		{
			temp[k] = array.get(j);
			j++;
			k++;
		}
		
		for(k = from; k <= to; k++)
		{
			array.set(k,temp[k]);
		}
	}
	
	
	
	/*The methods underneath the above methods are just modified versions 
	 * of the four sorting methods. They do not sort the lists based on 
	 * any variable such as their name or population number.
	 */
	
	
	/**
	 *	Bubble Sort algorithm - in ascending order
	 *	@param arr		array of Integer objects to sort
	 */
	public void bubbleSort(List<City> city) 
	{
			for(int outer = city.size() -1; outer > 0; outer--)
				for(int inner = 0; inner < outer; inner++)
					if(city.get(inner).compareTo(city.get(inner+1)) > 0)
						swap(city, inner, inner + 1);
	}
	
	/**
	 *	Swaps two Integer objects in array arr
	 *	@param arr		array of Integer objects
	 *	@param x		index of first object to swap
	 *	@param y		index of second object to swap
	 */
	private void swap(List<City> city, int x, int y) 
	{
		City temporary = city.get(x);
		
		city.set(x, city.get(y));
		city.set(y, temporary);
	}
	
	/**
	 *	Selection Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void selectionSort(List<City> arr) 
	{
		
		for(int i = arr.size(); i > 0; i --)
		{
			int pointer1 = 0;
			for(int pointer2 = 1; pointer2 < i; pointer2++)
			{
				if(arr.get(pointer1).compareTo(arr.get(pointer2)) < 0)
				{
					pointer1 = pointer2;
				}
			}
			
			swap(arr, pointer1, i-1);
		}
	}
	
	/**
	 *	Insertion Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void insertionSort(List<City> arr) 
	{
		for(int i = 1; i < arr.size(); i ++)
		{
			City temporary = new City(arr.get(i));
			
			int n = i;
			while(n > 0 && arr.get(n-1).compareTo(temporary) > 0)
			{
				swap(arr, n, n-1);
				n--;
			}
			
			arr.set(n, temporary);
		}
	}
	
	/**
	 *	Merge Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void mergeSort(List<City> arr)
	{
		int n = arr.size();
		temp = new City[n];
		recursiveSort(arr, 0, n-1);
	}
	
	public void recursiveSort(List<City> array, int from, int to)
	{
		if(to - from < 2)
		{
			if(to > from && array.get(to).compareTo(array.get(from)) < 0)
			{
				swap(array, to, from);				
			}
		}
		else
		{
			int middle = (from + to)/2;
			recursiveSort(array, from, middle);
			recursiveSort(array, middle + 1, to);
			merge(array, from, middle, to);
		}
		
	}
	
	public void merge(List<City> array, int from, int middle, int to)
	{
		int i = from;
		int j = middle+1;
		int k = from;
		
		while(i <= middle && j <= to)
		{
			if(array.get(i).compareTo(array.get(j)) < 0)
			{
				temp[k] = array.get(i);
				i++;
			}
			else
			{
				temp[k] = array.get(j);
				j++;
			}
			k++;
		}
		
		while(i <= middle)
		{
			temp[k] = array.get(i);
			i++;
			k++;
		}
		
		while(j <= to)
		{
			temp[k] = array.get(j);
			j++;
			k++;
		}
		
		for(k = from; k <= to; k++)
		{
			array.set(k,temp[k]);
		}
	}
		
	
	/*****************************************************************/
	/************************* For Testing ***************************/
	/*****************************************************************/
	
	/**
	 *	Print an array of Integers to the screen
	 *	@param arr		the array of Integers
	 */
	public void printArray(List<City> arr) {
		if (arr.size() == 0) System.out.print("(");
		else System.out.printf("( %4s", arr.get(0));
		for (int a = 1; a < arr.size(); a++) {
			if (a % 10 == 0) System.out.printf(",\n  %4s", arr.get(a));
			else System.out.printf(", %4s", arr.get(a));
		}
		System.out.println(" )");
	}

	public static void main(String[] args) {
		SortMethods se = new SortMethods();
		se.run();
	}
	
	public void run() {
		Integer[] arr = new Integer[10];
		// Fill arr with random numbers
	/*
		for (int a = 0; a < 10; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nBubble Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		bubbleSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();
		
	
		for (int a = 0; a < 10; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nSelection Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		selectionSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();
	
	
		for (int a = 0; a < 10; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nInsertion Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		insertionSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();

		
		for (int a = 0; a < 10; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nMerge Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		mergeSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();
*/
	}
}
