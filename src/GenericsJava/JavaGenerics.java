package GenericsJava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JavaGenerics {
    public static void main(String[] args) {
        Container<Integer,String> con = new Container<>(12,"Heya");
        int val = con.getItem1();
        String val2 = con.getItem2();

        Set<String> mySet = new HashSet<>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");

        Set<String> mySet2 = new HashSet<>();
        mySet2.add("C");
        mySet2.add("D");
        mySet2.add("E");

        Set<String> resultSet = union(mySet,mySet2);

        Iterator<String> it = resultSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //this declaration is allowed in OOP as Accountant is child of Employee
        Employee emp1 = new Employee();
        Employee emp2 = new Accountant();
        emp1 = emp2;

        //but when using generics this scenario is not allowed
        ArrayList<Employee> e = new ArrayList<>();
        ArrayList<Accountant> a = new ArrayList<>();
        //e=a;//gives error

        //to achieve the above scenario , WILDCARD character comes into the save
        //? - wildcard
        ArrayList<?> employees2 = new ArrayList<>();
        ArrayList<?> accountant = new ArrayList<>();

        //UPPER bound
        //children of employee
        // lower till end of hierachy / till end of the sub-sub classes of Employee
        //cannot include objects of class above
        ArrayList<? extends Employee> employees = new ArrayList<>();
        ArrayList<Accountant> acc = new ArrayList<>();
        ArrayList<Object> obj1 = new ArrayList<>();
        employees = acc; //this is allowed
        //employees = obj1 // this is not allowed , gives error , as Object is above Employee in hierarchy


        //LOWER bound
        //will not allow children of Employee
        //only Objects of Class Employee or super Classes of Employee Allowed
        //lower bound - Employee
        ArrayList<? super Employee> employees3 = new ArrayList<>();
        ArrayList<Accountant> acc2 = new ArrayList<>();
        ArrayList<Object> obj2 = new ArrayList<>();
        employees3 = obj2; //this is allowed here
        //employees3 = acc2 //not alllowed here , gives error , as Accountant is lower in hierarchy than Employee
    }
    //Generic Method Example
    public static <E> Set<E> union(Set<E> s1,Set<E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);

        return result;

    }
}
