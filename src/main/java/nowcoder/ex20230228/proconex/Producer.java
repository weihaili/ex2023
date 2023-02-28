package nowcoder.ex20230228.proconex;

import java.nio.Buffer;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 9:54
 */
public class Producer implements Runnable {

    private BufferArea bufa;

    public Producer(BufferArea bufa) {
        this.bufa = bufa;
    }
    @Override
    public void run() {
        while (true) {
            setIntervalTime();
            bufa.set();
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
