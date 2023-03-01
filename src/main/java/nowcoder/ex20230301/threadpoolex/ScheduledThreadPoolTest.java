package nowcoder.ex20230301.threadpoolex;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/1 9:58
 */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledThreadPoolTest demo = new ScheduledThreadPoolTest();
        ScheduledExecutorService scheduledThreadPool = demo.getScheduledThreadPool();
        demo.schedule(scheduledThreadPool);
    }

    private void schedule(ScheduledExecutorService scheduledThreadPool) {
        for (int i = 0; i < 2; i++) {
            scheduledThreadPool.scheduleAtFixedRate(new MinceThread(10), 3, 1 ,TimeUnit.SECONDS);
        }
    }

    private ScheduledExecutorService getScheduledThreadPool() {
        return Executors.newScheduledThreadPool(10);
    }
}
