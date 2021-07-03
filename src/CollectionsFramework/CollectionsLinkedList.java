package CollectionsFramework;

import java.util.LinkedList;
import java.util.Queue;

public class CollectionsLinkedList {
    public static void main(String[] args) {
        //implements both LIST and QUEUE interfaces
        //queue FIFO data sructure
        Queue<String> vaccinationQueue = new LinkedList<>();
        //offer , poll , peek , remove , element all these methods are of queue interface

        //add elements
        // offer returns true if added successfully else false
        //another functiom vaccinationQueue.add() returns true if added successfully else throws an EXCEPTION
        vaccinationQueue.offer("Ritesh");
        vaccinationQueue.offer("Rajesh");
        vaccinationQueue.offer("Suresh");
        vaccinationQueue.offer("Vivek");
        vaccinationQueue.offer("Sunidhi");
        vaccinationQueue.offer("Sakshi");

        //print queue
        System.out.println(vaccinationQueue);

        //remove the first element and also return it , returns null if empty
       // another method remove() does same but throws EXCEPTION if queue is empty

        System.out.println(vaccinationQueue.poll()+" got vaccinated");

        //get the first element not delete
        //another method element() also does same but throws exception if empty
        System.out.println(vaccinationQueue.peek()+" is next to enter the vaccination room");






    }
}
