package CollectionsFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionsArrayList {
    public static void main(String args[]){
        //ArrayList provides dynamic sized arrays
        List<String> students = new ArrayList<String>();
        List<String> newStudents = new ArrayList<String>();
        //default add method adds at the end
        students.add("Ritesh");
        students.add("Rakesh");
        students.add("Shruti");
        students.add("Shrishti");
        System.out.println(students);
        //add function that adds at a particular location
        students.add(2,"Rajesh");
        System.out.println(students);

        newStudents.add("Rajni");
        newStudents.add("Akshay");
        //add function that appends one collection to another
        students.addAll(newStudents);
        System.out.println(students);
        //add function that appends one collection to another at specified index
        students.addAll(1,newStudents);
        System.out.println(students);


        //get an element at particular index/position
        System.out.println(students.get(5));

        //remove a particular index
        students.remove(2);
        System.out.println(students);

        //remove a particular object
        students.remove("Rakesh");
        System.out.println(students);

        //removes all the elements of the given collection
        students.removeAll(students);
        System.out.println(students);

        students.removeIf(n->(n.contains("Raj")));
        System.out.println(students);

        //change element at particular index
        students.set(2,"Sharmila");
        //traversing array list
        //1. using for loop
        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i));
        }

        //2. using forEach loop
        for(String student : students){
            System.out.println(student);
        }

        // 3. using iterator

        Iterator<String> it = students.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //other important methods :
        //1.get size
        System.out.println(students.size());
        //2.check whether element exists
        System.out.println(students.contains("Rsjesh"));
        //3.check whether elements of one list are present in another
        System.out.println(students.containsAll(newStudents));
        //4.get the hashchode to compare with other
        System.out.println(students.hashCode());
        //5. get the required part of the list from specified locations
        System.out.println(students.subList(2,4));
        //6. get whether the list is empty or not
        System.out.println(students.isEmpty());
        //7. convert the list to array
        System.out.println(students.toArray());

       // int [][] queries = new int[3][3]





    }
}
