package JavaLambdas;
//add annotation to make sure not more than one method implemented
@FunctionalInterface
public interface LambdasInterface {
    public abstract void method1();
    //only one method for functional interface
}

//Ways to use this Interface :
//1. Create a new class and implement the above interface
//2. Anonymous class
//3. Lambda