package leetcdoe.ex202302015;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 9:40
 */
public class SynchroinzedInstanceMethod {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SynchroinzedInstanceMethod demo = new SynchroinzedInstanceMethod();
        demo.testCallable();
        //demo.testRunnable();

    }

    private void testRunnable() {
        Thread t1 = new Thread(new Acnt());
        Thread t2 = new Thread(new Acnt());
        t1.start();
        t2.start();
    }

    private void testCallable() throws InterruptedException, ExecutionException {
        AccountSync callable = new AccountSync();
        FutureTask ft1 = new FutureTask<>(callable);
        FutureTask ft2 = new FutureTask<>(callable);
        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);
        t1.start();

        t2.start();
        System.out.println("ft1: i = "+ft1.get());
        System.out.println("ft2: i = "+ft2.get());
    }
}

class AccountSync implements Callable {

    static int i = 0;

    volatile int j = 10000;

    static int m = 0;


    private int plus() {
        synchronized (this) {
            ++m;
        }
        return m;
    }

    public synchronized int increase() {
        return ++i;
    }

    public int minus () {
        return --j;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("thread name: " + Thread.currentThread().getName() + " start");
        for (int i = 0; i < 10000; ++i) {
            increase();
        }
        System.out.println("thread name: " + Thread.currentThread().getName() + " end");
        return i;
    }
}

class Acnt implements Runnable {

    static int i = 0;

    private synchronized void increase() {
        ++i;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; ++i) {
            increase();
        }
        System.out.println(Thread.currentThread().getName() + " i : " + i);
    }
}
