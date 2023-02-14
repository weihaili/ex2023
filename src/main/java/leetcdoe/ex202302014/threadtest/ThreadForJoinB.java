package leetcdoe.ex202302014.threadtest;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/14 10:34
 */
public class ThreadForJoinB extends Thread{

    public void run() {
        System.out.println("thread name: "+ Thread.currentThread().getName() + "sleep 10s");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("interupted excepiton");
            throw new RuntimeException(e);
        }
        System.out.println("thread name: "+ Thread.currentThread().getName() + "sleep end");
    }
}
