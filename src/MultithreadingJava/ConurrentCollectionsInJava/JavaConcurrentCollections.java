package MultithreadingJava.ConurrentCollectionsInJava;

import java.util.Random;
import java.util.concurrent.*;

public class JavaConcurrentCollections {
    public static final String EOF ="EOF";
    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);
        //ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyProducer1 producer = new MyProducer1(buffer,"YELLOW");
        MyConsumer1 consumer = new MyConsumer1(buffer,"PURPLE");
        MyConsumer1 consumer2 = new MyConsumer1(buffer,"CYAN");

        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.execute(consumer2);


        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("IM BEING PRINTED FROM CALLABLE CLASS");
                return "This is the callable result";
            }
        });
        try{
            System.out.println(future.get());
        }catch (ExecutionException e){
            System.out.println("Something went wrong");
        }catch (InterruptedException e){
            System.out.println("Thread running interrupted");
        }


        executorService.shutdown();

        // executorService.shutdownNow(); // to shutdown any task immediately , sutting all the remaining tasks also
//        new Thread(producer).start();
//        new Thread(consumer).start();
//        new Thread(consumer2).start();
    }
}
class MyProducer1 implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;
   // private ReentrantLock bufferLock;

    public MyProducer1(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
        //this.bufferLock = bLock;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};
        for(String num : nums){
            try{
                System.out.println(color + "Adding...."+num);
                buffer.put(num);

                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){

            }
        }
        System.out.println(color + "Adding EOF and exiting..........");
       try {
           buffer.put(ConcurrentPackageInJava.EOF);
       }catch (InterruptedException e){

       }


    }
}
class MyConsumer1 implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;
   // private ReentrantLock bufferLock;
    public MyConsumer1(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
       // this.bufferLock = bLock;
    }
    public void run(){
        while (true) {
            //some synchronization still needed
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        // bufferLock.unlock();
                        continue;
                    }
                    if (buffer.peek().equals(ConcurrentPackageInJava.EOF)) {
                        System.out.println("Exiting");
                        // bufferLock.unlock();
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }

            }
        }
    }
}

