package leetcdoe.ex202302015;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 11:43
 */
public class SynchronizedCodeBlock {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SynchronizedCodeBlock demo = new SynchronizedCodeBlock();
        demo.testCallable();
        //demo.testRunnable();
    }

    private void testRunnable() {
        CalRunable ra = new CalRunable();
        Thread t1 = new Thread(ra);
        Thread t2 = new Thread(ra);
        t1.start();
        t2.start();

    }

    private void testCallable() throws InterruptedException, ExecutionException {
        CalCala cal = new CalCala();
        FutureTask task = new FutureTask(cal);
        Thread t1 = new Thread(task);
        CalCala cal2 = new CalCala();
        FutureTask task2 = new FutureTask(cal2);
        Thread t2 = new Thread(task2);
        t1.start();
        t1.join();
        System.out.println(task.get());
        t2.start();
        t2.join();
        System.out.println(task.get());
    }
}

class CalCala implements Callable {

    private static int cnt = 0;

    private int plus() {
        synchronized (this) {
            ++cnt;
        }
        return cnt;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " : run start " + cnt);
        for (int i = 0; i < 100000; ++i) {
            plus();
        }
        System.out.println(Thread.currentThread().getName() + " : run end " + cnt);
        return cnt;
    }
}

class CalRunable implements Runnable {

    private static int cnt = 0;

    private int plus() {
        synchronized (this) {
            ++cnt;
        }
        return cnt;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : run start " + cnt);
        for (int i = 0; i < 10000; ++i) {
            plus();
        }
        System.out.println(Thread.currentThread().getName() + " : run end " + cnt);
    }
}
