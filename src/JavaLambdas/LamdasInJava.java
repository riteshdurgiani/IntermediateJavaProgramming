package JavaLambdas;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.*;

public class LamdasInJava {
    public static void main(String[] args) {


        //anonymous class
        LambdasInterface myInter = new LambdasInterface() {
            @Override
            public void method1() {
                System.out.println("From Anonymous");
            }
        };
        myInter.method1();

        //Labmda implementation
        LambdasInterface lambda = ()-> System.out.println("Lambda Implemented");
        lambda.method1();

        MultiplyInterface m1 = (a,b)-> a*b;
        //type not given but how does compiler know type of variable ?
        //From left Hand side , it checks the type of the variable in the interface and assigns that
        //to the variables used in the arguments
        System.out.println("Product is : " + m1.multiply(20,10));

        ArrayList<Integer> al = new ArrayList<>();
        al.add(23);
        al.add(30);
        al.add(32);

        //using enhanced for loop
        //Consumer functional interface provided by java.util.function
        al.forEach(a->{
            System.out.println(a);
        });

        //what if we want to check some condtion ?
        //we can do by making use of the Predicate Functional Interface
        checking(al,"Elements above 30",a->a>30);
        checking(al,"Elements less than equal to 30",a->a<=30);

        //using anonymous classs
        checking(al, "Elements > 30", new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer>30;
            }
        });

        //types of Predicates - Int,Double
        IntPredicate intP = i->i>5;
        System.out.println(intP.test(20));
        DoublePredicate doubP = d->d<3.56;
        System.out.println(doubP.test(89.00));

        //predicate chaining - checking multiple conditions

        IntPredicate i1 = i->i>10;
        IntPredicate i2 = i->i<90;
        System.out.println(i1.and(i2).test(80));

        //supplier
        Random rand = new Random();
        Supplier<Integer> randSup = () -> rand.nextInt(1000);
        for (int i=0;i<10;i++){
            System.out.println(randSup.get());
        }

        //Print last names of employees ( Assume ArrayList of type Employees)

        //create a function using java.util.function
//        Function<Employee,String> getLastName = (Employee employee)->{
//            return employee.getName().substring(employee.getName().indexOf(' '+1));
//
//        }
//        //Call the function using apply method
//        String lastName = getLastName.apply(Employees.get(1));

        // call any method first or last name
//        Function<Employee,String> getFirstName = (Employee e)->{
//            return e.getName().substring(0,employee.getName().indexOf(' '));
//
//        }

//        Random r1 = new Random();
//        for(Employee e : employees){
//            if(r1.nextBoolean()){
//                System.out.println(getAName(getFirstName,e));
//            }
//        }
//        private static  String getAName(Function<Employee,String> getName , Employee emp){
//            return getAName.apply(emp);
//        }

        Function<Integer,String> toStringCon = i ->{
            return i.toString();
        };

        Function<String,Integer> toIntBack = s->Integer.parseInt(s);

        //functions CHAINING
        Function chainedFunction = toStringCon.andThen(toIntBack);

        System.out.println((chainedFunction.apply(al.get(1))).getClass());

        //BiFunction
        String testing = "Hello";
        BiFunction<String,Integer,String> testBi = (String a,Integer b)->{
            return a.concat(b.toString());

        };
        //BiFunctions can only be chained if they are the first one to be called in the chain

        IntUnaryOperator incBy5 = i->i+5;
        System.out.println(incBy5.applyAsInt(10));
        DoubleUnaryOperator doubBy10;
        LongUnaryOperator longBy10;






    }
    public static void checking(ArrayList<Integer> al, String conditionText, Predicate<Integer> checkCondition){
        System.out.println(conditionText);
        for(Integer i : al){
            if(checkCondition.test(i)){
                System.out.println(i);
            }
        }
    }

}
