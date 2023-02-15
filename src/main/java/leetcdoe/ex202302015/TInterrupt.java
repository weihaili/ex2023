package leetcdoe.ex202302015;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 14:25
 */
public class TInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    while (true) {
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (InterruptedException e) {
                    System.out.println("interrupt when sleep");
                    boolean interrupted = this.isInterrupted();
                    System.out.println("interrupt : " + interrupted);
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();
    }
}
