package MultithreadingJava;

public class MultithreadinInJava {
    public static void main(String[] args) {
        System.out.println("This is main thread");

        //way 1 : Create a class extending thread
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("====Another Thread=====");
        anotherThread.start();

        //the most common mistake to avoid is
        //we do not call the run method ,intead we call the start method , JVM internally calls run method
        //But what happens if we call the run method ?
        //It runs on the currently executing thread and not on the new created thread
        //anotherThread.run();
        //it returns current invoking threads name as Main
        //but ideally should return AnotherThread



        //way 2 : Anonymous class
        new Thread(){
            public void run(){
                System.out.println("Hello from anonymous");
            }
        }.start();

        //way 3 : Using class that implements Runnable
        Thread runnableThread = new Thread(new MyRunnable());
        runnableThread.start();


        //way 4 : anonymous runnable
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("From Anonymous Runnable");
            }
        }).start();


        //or
        Thread runAnony = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println("From Anonymous MyRunnable");
                try{
                    //joins this thread to the current thread after it completes its execution
                    anotherThread.join(2000);

                    System.out.println("Another thread terminated or timed out so Im running");
                }catch (InterruptedException e){
                    System.out.println("I WAS INTERRUPTED");
                }
            }
        });
        runAnony.start();
        //anotherThread.interrupt();

        System.out.println("HElloo");





    }
}
