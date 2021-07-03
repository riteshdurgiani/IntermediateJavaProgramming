package MultithreadingJava.Deadlock;

public class Main {
    //this is an example of deadlock  3
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 1 :HAS THE LOCK1");
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println();
                }
                System.out.println("Thread 1 : WAITING FOR LOCK 2");
                synchronized (lock2){
                    System.out.println("Thread 1: Has Lock 1 and Lock 2");
                }
                System.out.println("Thread 1 : Realeased lock2");
            }
            System.out.println("Thread 1 : Released lock1. Exiting.....");
        }
    }

    private static class Thread2 extends Thread{
        public void run(){
            synchronized (lock2){
                System.out.println("Thread 2 : has lock 2");
                try {
                    Thread.sleep(100);

                }catch (InterruptedException e){

                }
                System.out.println("Thread 2 : Waiting for lock1");
                synchronized (lock1){
                    System.out.println("Thread 2 : Has lock2 and lock1");
                }
                System.out.println("Thread 2 : released lock1");
            }
            System.out.println("Thread 2 : Released lock2 . Exiting ...");
        }
    }
}

