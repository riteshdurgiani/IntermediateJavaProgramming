package MultithreadingJava;

public class MoreThreadExamples {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread1");
        CountdownThread t2 = new CountdownThread(countdown);
        t1.setName("Thread2");

        t1.start();
        t2.start();
    }
}
class Countdown{
    String color;
    private int i;
    public synchronized void countDown(){
        System.out.println(Thread.currentThread().getName());
        switch (Thread.currentThread().getName()){
            case "Thread-1":
                color = "CYAN";
                break;
            case "Thread2":
                color = "PURPLE";
                break;
            default:
                color="ORANGE";
        }
        //while synchronizing , only synchronize what needs to be
        synchronized (this){
            //as only objects have locks , only Object type variables can be synchronized in this way
            //also this object should be one that is shared by the threads
            for (i=10;i>0;i--){
                System.out.println(color+Thread.currentThread().getName() + ": i= "+ i);
            }
        }

    }
}
class CountdownThread extends Thread{
    private Countdown threadCountdown;
    public CountdownThread(Countdown countdown){
        threadCountdown = countdown;
    }
    public void run(){
        threadCountdown.countDown();
    }
}
