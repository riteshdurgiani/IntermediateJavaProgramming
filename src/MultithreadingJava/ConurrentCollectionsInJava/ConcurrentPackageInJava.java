package MultithreadingJava.ConurrentCollectionsInJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentPackageInJava {
    public static final String EOF ="EOF";
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyProducer producer = new MyProducer(buffer,"YELLOW",bufferLock);
        MyConsumer consumer = new MyConsumer(buffer,"PURPLE",bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer,"CYAN",bufferLock);

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
class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color,ReentrantLock bLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bLock;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};
        for(String num : nums){
            try{
                System.out.println(color + "Adding...."+num);
                    bufferLock.lock();
                    try {
                        buffer.add(num);
                    }finally {
                        bufferLock.unlock();
                    }


                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){

            }
        }
        System.out.println(color + "Adding EOF and exiting..........");
        bufferLock.lock();
        try {
            buffer.add(ConcurrentPackageInJava.EOF);
        }finally {
            bufferLock.unlock();
        }



    }
}
class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;
    public MyConsumer(List<String> buffer, String color,ReentrantLock bLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bLock;
    }
    public void run(){
        while (true){
            bufferLock.lock();
            try {
                if (buffer.isEmpty()) {
                   // bufferLock.unlock();
                    continue;
                }
                if (buffer.get(0).equals(ConcurrentPackageInJava.EOF)) {
                    System.out.println("Exiting");
                   // bufferLock.unlock();
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            }finally {
                bufferLock.unlock();
            }

        }
    }
}
