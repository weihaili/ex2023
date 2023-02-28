package nowcoder.ex20230228.proconex;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 9:56
 */
public class BufferArea implements Serializable {

    private AtomicInteger curNum;

    private int maxNum;

    public BufferArea(int maxNum) {
        curNum = new AtomicInteger();
        this.maxNum = maxNum;
    }

    public synchronized void set() {
        try {
            if (curNum.get() > maxNum) {
                System.out.println("thread name: " + Thread.currentThread().getName());
                wait();
            } else {
                curNum.incrementAndGet();
                System.out.println("thread name: " + Thread.currentThread().getName());
                notifyAll();
            }
        } catch (InterruptedException e) {
            System.err.println("set err: " + e.getMessage());
        }
    }

    public synchronized void get() {
        try {
            if (curNum.get() < 1) {
                System.out.println("thread name: " + Thread.currentThread().getName());
                wait();
            } else {
                curNum.decrementAndGet();
                System.out.println("thread name: " + Thread.currentThread().getName());
                notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
