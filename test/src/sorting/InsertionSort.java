package sorting;

import java.util.Arrays;

public class InsertionSort {
	
	public void sort(int[] array){
		for(int i=1 ; i<array.length ; i++){
			System.out.println(Arrays.toString(array));
			int currentKey = array[i];
			int j= i - 1;
			while(j >= 0 && array[j] > currentKey){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = currentKey;
		}
	}
}
