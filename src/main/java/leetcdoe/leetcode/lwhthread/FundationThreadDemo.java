package leetcdoe.leetcode.lwhthread;

import java.util.concurrent.*;

public class FundationThreadDemo {

    public static void main(String[] args) {
        Thread thread = new RunThread();
        System.out.println("1" + thread.getState() + ":" + Thread.currentThread().getId());
        thread.run();
        System.out.println("2" + thread.getState() + ":" + Thread.currentThread().getId());
        thread.start();
        System.out.println("3" + thread.getState() + ":" + Thread.currentThread().getId());
        try {
            thread.join();
            System.out.println("4" + thread.getState() + ":" + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage() + "error occor");
        }
        System.out.println("5" + thread.getState() + ":" + Thread.currentThread().getId());

        Thread walk = new Thread(new Walk());
        walk.start();
        System.out.println("6" + thread.getState() + ":" + Thread.currentThread().getId());

        FutureTask<Long> task = new FutureTask(new Crawl());
        new Thread(task).start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException" + e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("ExecutionException" + e.getMessage());
        }

        ExecutorService service = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) service;
        poolExecutor.setCorePoolSize(8);
        poolExecutor.execute(new Walk());

        poolExecutor.submit(new Crawl());

        poolExecutor.shutdown();

        ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        cachedThreadPool.setCorePoolSize(8);
        cachedThreadPool.execute(new Walk());
        cachedThreadPool.submit(new Crawl());
        cachedThreadPool.shutdown();

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(new Walk());
        singleThreadExecutor.submit(new Crawl());
        singleThreadExecutor.shutdownNow();

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

        for (int i = 0; i < 10; i++) {

            scheduledThreadPool.schedule(new Crawl(), 1L, TimeUnit.SECONDS);

            scheduledThreadPool.schedule(new Walk(), 1L, TimeUnit.SECONDS);
        }

        scheduledThreadPool.shutdownNow();

    }
}

/**
 * create thread method 3: create class A implements callable interface override call method
 *
 * start: instance FutureTask use A instance , create Thread instance use FutureTask instance
 *        thread.start()
 */
class Crawl implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        System.out.println("aaa01" + Thread.currentThread().getState() + Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getThreadGroup());
        return Thread.currentThread().getId();
    }
}

    /**
     * create thread method 2: declare new class implements Runnable interface ,override run method
     * <p>
     * start new thread: create new Thread by Thread(Runnable ins).start();
     */
    class Walk implements Runnable {

        @Override
        public void run() {
            System.out.println("002" + Thread.currentThread().getState() + ":" + Thread.currentThread().getId());

            try {
                Thread.sleep(1000L);
                System.out.println("003" + Thread.currentThread().getState() + ":" + Thread.currentThread().getId());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage() + "error occur");
            }
            Thread.interrupted();
            System.out.println("004" + Thread.currentThread().getState() + ":" + Thread.currentThread().getId());

            Thread.yield();
            System.out.println("005" + Thread.currentThread().getState() + ":" + Thread.currentThread().getId());
        }
    }

    /**
     * create thread method 1: extend Thread override method run
     */
    class RunThread extends Thread {

        @Override
        public void run() {
            System.out.println("01" + this.getState() + ": " + this.getId());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                System.out.println("02" + e.getMessage() + ": " + this.getId());
            }
            System.out.println("03" + this.getState() + ": " + this.getId());
            Thread.currentThread().interrupt();
            System.out.println("04" + this.getState() + ": " + this.getId());
        }
    }
