package MultithreadingJava;

public class AnotherThread extends Thread{
    @Override
    public void run(){
        System.out.println("Hellofrom another thread  "+currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println("Another Thread woke me up");
            return;
        }

        System.out.println("5 seconds passed I'm awake");
    }
}
