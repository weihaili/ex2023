package leetcdoe.ex202302014.threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/14 8:34
 */
public class StatusChange {

    public static void main(String[] args) {
        StatusChange demo = new StatusChange();
        Thread newThread = demo.newThread();
        System.out.println(newThread.getState());

        demo.testYield();

        Callable cal;

        Future future;

        FutureTask futureTask = new FutureTask(new MyCallThread());
        new Thread(futureTask).start();

        Executors executor;

        Condition con;

    }

    private void testYield() {
        Thread producer = new ProducerForYield();
        producer.start();
        Thread consumer = new ConsumerForYield();
        consumer.start();
    }

    /**
     * 线程状态为0  NEW
     * @return
     */
    private Thread newThread() {
        return new Thread();
    }

}

class MyCallThread implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}
