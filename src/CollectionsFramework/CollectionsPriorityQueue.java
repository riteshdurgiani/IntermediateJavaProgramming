package CollectionsFramework;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CollectionsPriorityQueue {
    public static void main(String[] args) {

        PriorityQueue<Integer> vaccinePriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        //default priority is the smaller element has higher priority
        vaccinePriorityQueue.offer(99);
        vaccinePriorityQueue.offer(98);
        vaccinePriorityQueue.offer(18);
        vaccinePriorityQueue.offer(45);
        vaccinePriorityQueue.offer(60);


        System.out.println(vaccinePriorityQueue);
        System.out.println(vaccinePriorityQueue.peek());



    }
}
