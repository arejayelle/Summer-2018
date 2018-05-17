/**
 * Merge sort workshop with F. Lapierre
 * May 17th 2018
 * @author R_loke
 *
 */
public class mergeSort {
	/**
	 * This is a 2.5 method function
	 * In order to avoid creating many temporary arrays, we create a third method
	 * which is passed an array
	 * 
	 * @param arr
	 * @param lo
	 * @param hi
	 * @param temp
	 */
	private static void merge(int[] arr, int lo, int mid, int hi, int[] temp){
		/**
		 * Loop invariant?? (concept)
		 * lo is the first item of first partition;
		 * mid = last item of first partition;
		 * hi = last item of 2nd partition;
		 */

		for(int i = 0; i < arr.length; i++) {
			if(i == lo) {
				System.out.print("| ");
			}
			System.out.print(arr[i] + " ");
			if(i == hi) {
				System.out.print("| ");
			}
		}
		System.out.println();
		
		
		int part1Next = lo;  //Next slot from partition 1 to be merged
		int part2Next = mid + 1;  //Next slot from partition 2 to be merged
		int tempNext  = lo;  //Next slot from TEMP to be merged
		/**
		 * ACHTUNG!!! when you're sorting a partition of the array, you don't necessarily wanna start at 0;
		 * therefore you use LO then it's gucci
		 * goal is to have merged array in temp and then copy into the original array
		 */
		
		while(tempNext<=hi){
			if (part1Next>mid || (part2Next<=hi) && arr[part1Next]>arr[part2Next])
				/*
				 * don't forget to check validity of index
				 */
			{
				temp [tempNext++]= arr[part2Next++];	
			}
			else
			{ 			
				//ACTUNG because it doesn't matter in the equals case, just put an else. Doesn't matter where it's treated
				temp [tempNext++]= arr[part1Next++];	
			}
			
		}
		/*
		 * now copy worked part of temp to arr;
		 */
		for (int i=lo; i<=hi; i++){
			arr[i] = temp[i];
		}
		for(int i = 0; i < arr.length; i++) {
			if(i == lo) {
				System.out.print("| ");
			}
			System.out.print(arr[i] + " ");
			if(i == hi) {
				System.out.print("| ");
			}
		}
		System.out.println();
	}
	private static void mergesort(int[] arr, int lo, int hi, int[] temp){
		/**
		 * this is a recursive function so you need to establish the structure
		 */

		//base case: when low and hi are the same, then the array is size 1;
		if (lo ==hi)
			return;

		//Recursive step
		int mid = (lo+hi)/2;
		mergesort(arr,lo,mid,temp); //calls itself forever
		mergesort(arr, mid+1, hi, temp);
		merge(arr, lo, mid, hi, temp);
	}


	public static void sort(int[] arr) {
		int lo =0;
		int hi = arr.length-1;
		int mid=((hi+lo)/2);

		int [] temp = new int[arr.length];
		mergesort(arr,lo,mid,temp);
		mergesort(arr,mid+1, hi, temp);
		merge(arr,lo,mid, hi, temp);

	}

	public static void main(String[] args){
		int[] array = new int[10];
		array[0] = 15;
		array[1] = 10;
		array[2] = 1;
		array[3] = 5;
		array[4] = 7;
		array[5] = 14;
		array[6] = 9;
		array[7] = 3;
		array[8] = 11;
		array[9] = 0;
		
		System.out.println("This is the array: ");
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println("\n---------------");
		mergeSort.sort(array);
	}
}
