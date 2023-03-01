package nowcoder.ex20230301.threadpoolex;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/1 9:11
 */
public class CachedThreadPoolTest {

    public static void main(String[] args) {
        CachedThreadPoolTest demo = new CachedThreadPoolTest();
        ExecutorService cachedThreadPool = demo.getCachedThreadPool();
        demo.submitTask(cachedThreadPool);
        demo.invokeTask(cachedThreadPool);
    }

    private void invokeTask(ExecutorService cachedThreadPool) {
        List<AddThread> tasks = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            tasks.add(new AddThread());
        }
        List<Future> res = new ArrayList<>();
        try {
            cachedThreadPool.invokeAll(tasks);
        } catch (InterruptedException e) {
            System.err.println("invokeTask InterruptedException " + e.getMessage());
        }
    }

    private void submitTask(ExecutorService cachedThreadPool) {
        for (int i = 0; i < 100; ++i) {
            cachedThreadPool.submit(new MinceThread(10));
        }
    }

    private ExecutorService getCachedThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        return cachedThreadPool;
    }
}

class MinceThread implements Runnable {

    private AtomicInteger num;

    public MinceThread(int number) {
        num = new AtomicInteger(number);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println(Thread.currentThread().getName() + " runnable " + num.get());
            num.decrementAndGet();
        }
    }
}

class AddThread implements Callable<Integer> {

    private AtomicInteger num = new AtomicInteger();

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; ++i) {
            System.out.println(Thread.currentThread().getName() + " callable " + num.get());
            num.incrementAndGet();
        }
        return num.get();
    }
}
