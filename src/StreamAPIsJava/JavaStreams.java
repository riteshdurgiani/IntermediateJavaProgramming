package StreamAPIsJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
        List<String> someNumbers = Arrays.asList(
                "N40","N41",
                "G20","G10","G7","G5","g64",
                "B12","B32",
                "I88","I082",
                "O71"
        );

        //print elements that begin with G, add to another list , sort the list

        //1. Lambda way - using Enhanced forEach with Consumer
        ArrayList<String> gNumbers = new ArrayList<>();
        someNumbers.forEach(number->{
            if(number.toUpperCase().startsWith("G")){
                gNumbers.add(number);
            }
        });
        gNumbers.sort((String s1,String s2)->s1.compareTo(s2));
        gNumbers.forEach((String s)-> System.out.println(s));

        //2. The StreamsAPI way :

        someNumbers
                .stream() //create a stream with same ordering as source
                .map(String::toUpperCase) //map function maps each value of the stream and also perform some operation on it , ultimately returns a stream
                .filter(s->s.startsWith("G")) //filter method accepts a lambda expression(Predicate) , and based on result filters the stream
                .sorted() //sorts the FILTERED stream
                .forEach(System.out::println); //prints each element //terminal operation


        //Create stream from scratch
        Stream<String> ioNumberStream = Stream.of("I12","I01","I45","I31","I71");
        Stream<String> iNNumberString = Stream.of("O12","O01","O45","O31","O71","I45");

        //concat streams
        Stream<String> conattedString = Stream.concat(ioNumberStream,iNNumberString);
        //as concat is static cannot be used in chaining
        //but we can use result of concatenated string

        //get the number of elements in stream
        //System.out.println(conattedString.count());

        //remove the duplicates
        //System.out.println(conattedString.distinct().count());

        //forEach being terminal operation , cannot be used for printing the result of all of the operations in the pipeline i.e debugging
        //peek - intermediate operation
        //peek is used to do so , as it returns back the stream
        System.out.println("---------------------------");
        System.out.println(conattedString.
                distinct().
                peek(System.out::println).
                count());


        Employee1 john = new Employee1("John Doe",30);
        Employee1 jack = new Employee1("Jack Hill",30);
        Employee1 ritesh = new Employee1("Ritesh Durgiani",20);
        Employee1 mary = new Employee1("Mary Doe",25);
        Employee1 rajesh = new Employee1("Rajesh Nath",50);
        Employee1 suresh = new Employee1("Suresh Dane",30);

        Department hr = new Department("HR");
        hr.addEmployee(rajesh);
        hr.addEmployee(mary);
        Department technical = new Department("Technical");
        technical.addEmployee(ritesh);
        technical.addEmployee(suresh);
        technical.addEmployee(john);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(jack);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);
        departments.add(technical);

        //using flatmap to get all the employees
        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        //using collect method
        //collect - terminal operation

        //way1
//        List<String> sortedGNumbers = someNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s->s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        //way2
        List<String> sortedGNumbers = someNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
                //supplier,accumulator,combiner


        for (String s:
           sortedGNumbers  ) {
            System.out.println(s);
        }

        //using collectors.grouping by method
        Map<Integer,List<Employee1>> groupedByAge = departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee1 -> employee1.getGetAge()));


        //reduce method
        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1,e2)->e1.getGetAge()<e2.getGetAge()?e1:e2)
                .ifPresent(System.out::println);

        //once called terminal operation , cannot reuse
        //operations are lazily evaluated : intermidiate operations arent performed , untill there is a terminal operation



    }
}
