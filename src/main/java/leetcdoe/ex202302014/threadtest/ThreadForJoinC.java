package leetcdoe.ex202302014.threadtest;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/14 10:39
 */
public class ThreadForJoinC implements Runnable {

    @Override
    public void run() {
        System.out.println("thread name: "+ Thread.currentThread().getName() + "sleep 10s");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            throw new RuntimeException(e);
        }
        System.out.println("thread name: "+ Thread.currentThread().getName() + "sleep end");
    }
}
