package ExceptionHandlingJava;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x = 220;
        int y=0;
        int result = divideLBYL(x,y);
        System.out.println(result);
        result = divideEAFP(x,y);
        System.out.println(result);

        int getInteger = getIntLBYL();
        System.out.println(getInteger);

        getInteger = getIntException();
        System.out.println(getInteger );
    }

    private static int getIntLBYL(){
        //look before you leap way
        Scanner sc = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Enter an integer : ");
        String ip = sc.next();
        for(int i=0;i<ip.length();i++){
            if(!Character.isDigit(ip.charAt(i))){
                isValid = false;
                break;
            }else{
                return Integer.parseInt(ip);
            }


        }
        return 0;
    }
    private static int getIntException(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer : ");
        try{
            return sc.nextInt();
        }catch (InputMismatchException e){
            return 0;
        }
    }
    private static int divideLBYL(int x,int y){
        //test before you leap way or look before you leap, i.e , avoiding exception
        if(y!=0){
            return x/y;
        }else{
            return 0;
        }
    }
    private static int divideEAFP(int x,int y){
        //exception handling way
        try{
            return x/y;
        }catch (ArithmeticException e){
            return 0;
        }


    }
}
