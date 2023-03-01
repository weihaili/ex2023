package nowcoder.ex20230301.threadpoolex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/1 9:39
 */
public class FixedThreadPoolTest {

    public static void main(String[] args) {
        FixedThreadPoolTest demo = new FixedThreadPoolTest();
        ExecutorService  fixedThreadPool = demo.getFixedThreadPool();
        demo.submit(fixedThreadPool);
    }

    private void submit(ExecutorService fixedThreadPool) {
        for (int i = 0; i < 10; ++i) {
            fixedThreadPool.submit(new AddThread());
            fixedThreadPool.submit(new MinceThread(100));
        }
    }

    private ExecutorService getFixedThreadPool() {
        return Executors.newFixedThreadPool(15);
    }
}
