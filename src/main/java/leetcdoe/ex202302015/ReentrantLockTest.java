package leetcdoe.ex202302015;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 13:58
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLockTest demo = new ReentrantLockTest();
        demo.testCallable();
        demo.testRunnable();
    }

    private void testRunnable() {
        Cup cup = new Cup();
        Thread t1 = new Thread(cup);

        Cup cup2 = new Cup();
        Thread t2 = new Thread(cup2);

        t1.start();
        t2.start();
    }

    private void testCallable() {
        CupCallable ca = new CupCallable();
        CupCallable cab = new CupCallable();
        FutureTask task = new FutureTask<>(ca);
        Thread t1 = new Thread(task);
        FutureTask task1 = new FutureTask<>(cab);
        Thread t2 = new Thread(task1);
        t1.start();
        t2.start();
    }
}

class Cup implements Runnable {

    static int size = 0;

    private void expend() {
        synchronized (this) {
            ++size;
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "run start " + size);
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                expend();
            }
        }
        System.out.println(Thread.currentThread().getName() + "run end " + size);
    }
}

class CupCallable implements Callable {

    static int size = 0;

    private synchronized void expend() {
        ++size;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " run start " + size);
        synchronized (CupCallable.class) {
            for (int i = 0; i < 100000; i++) {
                expend();
            }
        }
        System.out.println(Thread.currentThread().getName() + " run end " + size);
        return size;
    }
}
