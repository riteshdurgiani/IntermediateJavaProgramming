package CollectionsFramework;

import java.util.Stack;

public class CollectionsStack {
    public static void main(String args[]){
        Stack<String> animals = new Stack<>();

        //adding elements
        animals.push("Lion");
        animals.push("Tiger");
        animals.push("Cheetah");
        animals.push("Leapord");
        animals.push("Snake");

        System.out.println(animals);

        //view the top element of the stack
        System.out.println(animals.peek());

        //delete element from stack : ALWAYS THE LAST INSERTED ELEMENT
        System.out.println(animals.pop());

        //again peek
        System.out.println(animals.peek());
        System.out.println(animals);

        //search an element (Returns distance of the found element from top of the stack )
        System.out.println(animals.search("Tiger"));

        //check if the stack is empty
        System.out.println(animals.empty());

        //other methods
        System.out.println(animals.firstElement());
        System.out.println(animals.lastElement());
        System.out.println(animals.capacity());
        System.out.println(animals.size());
    }
}
