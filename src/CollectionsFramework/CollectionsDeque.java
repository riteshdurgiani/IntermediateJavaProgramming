package CollectionsFramework;

import java.util.ArrayDeque;

public class CollectionsDeque {
    public static void main(String[] args) {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        //default offer method from queue
        arrayDeque.offer("Ritesh");

        //DEQUE specific method to add
        arrayDeque.addFirst("Rajesh");
        arrayDeque.addLast("Senorita");
        arrayDeque.offer("Rinki");
        arrayDeque.offer("Chinki");

        System.out.println(arrayDeque);

        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.peekFirst());
        System.out.println(arrayDeque.peekLast());

        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.pollLast());
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.pollFirst());
        System.out.println(arrayDeque);

    }
}
