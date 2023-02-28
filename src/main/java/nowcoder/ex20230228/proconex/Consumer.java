package nowcoder.ex20230228.proconex;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 10:08
 */
public class Consumer implements Runnable {

    private BufferArea bufa;

    public Consumer(BufferArea bufa) {
        this.bufa = bufa;
    }

    @Override
    public void run() {
        while (true) {
            setIntervalTime();
            bufa.get();
        }
    }

    private void setIntervalTime() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println("setIntervalTime err: " + e.getMessage());
        }
    }
}
