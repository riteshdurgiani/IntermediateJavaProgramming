package ExceptionHandlingJava;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExceptionExamples {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        }catch (NoSuchElementException | ArithmeticException e){
            System.out.println(e.toString());
            System.out.println("Unable to perform ");
        }
    }
    private static int divide(){
        int x,y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("X is" + x +"Y is " + y);
            return x / y;
        }catch (NoSuchElementException e){
            throw new ArithmeticException("No Suitable input");
        }catch (ArithmeticException e){
            throw new ArithmeticException("Attempt to divide by zero");
        }


    }
    private static int getInt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer : ");
        return sc.nextInt();
    }
}
