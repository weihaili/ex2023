package leetcdoe.ex202302015;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 11:08
 */
public class SynStaticMethodTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SynStaticMethodTest demo = new SynStaticMethodTest();
//        demo.testCallable();
        demo.testRunnable();
    }

    private void testRunnable() {
        ConsumerRun instance = new ConsumerRun();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(new ConsumerRun());
        t1.start();
        t2.start();

    }

    private void testCallable() throws ExecutionException, InterruptedException {
        ConsumerCal instance = new ConsumerCal();
        FutureTask ft1 = new FutureTask<>(instance);
        FutureTask ft2 = new FutureTask<>(new ConsumerCal());
        FutureTask ft3 = new FutureTask<>(new ConsumerCal());
        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);
        Thread t3 = new Thread(ft3);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(ft1.get() + " : " + ft2.get() + " : " + ft3.get());
    }
}

class ConsumerCal implements Callable {

    static int cnt = 0;

    private synchronized static int autoPlus() {
        return cnt++;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "run start cnt: " + cnt);
        for (int i = 0; i < 1000000; i++) {
            autoPlus();
        }
        System.out.println(Thread.currentThread().getName() + "run end cnt: " + cnt);
        return cnt;
    }
}

class ConsumerRun implements Runnable {

    static int cnt = 0;

    private synchronized static int autoPlus() {
        return ++cnt;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run start");
        for (int i = 0; i < 1000000; ++i) {
           autoPlus();
        }
        System.out.println(Thread.currentThread().getName() + " run end .cnt: " + cnt);
    }
}
