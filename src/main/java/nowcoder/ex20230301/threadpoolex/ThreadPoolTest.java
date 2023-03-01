package nowcoder.ex20230301.threadpoolex;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/1 8:57
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ScheduledExecutorService singleScheduledThreadExecutor = Executors.newSingleThreadScheduledExecutor();
        BlockingDeque que = new LinkedBlockingDeque();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10,5, TimeUnit.SECONDS,que);
    }
}
