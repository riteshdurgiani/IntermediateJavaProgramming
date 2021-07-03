package CollectionsFramework;

import java.util.Arrays;

public class ArraysClass {
    public static void main(String[] args) {
        int numbers[] = {78,4,23,7,90,12,34,67,89,55};
        //sort method  : uses QuickSort to sort
        Arrays.sort(numbers);
        for (int i=0;i<numbers.length;i++){
            System.out.print(numbers[i] + " ");
            System.out.println();
        }
        //binary search function : works in O(log(n))
        int index = Arrays.binarySearch(numbers,12);
        System.out.println("The index of the required element is : " + index);

        //parallel sort function
        //divides the arrayto multiple processors
        //faster then quick sort
        // elements should be more than 8192
        Arrays.parallelSort(numbers);

        //fill array with default value
        Arrays.fill(numbers,23);
        for (int i:numbers) {
            System.out.println(i);
        }







    }
}
