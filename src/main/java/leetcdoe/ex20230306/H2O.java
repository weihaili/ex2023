package leetcdoe.ex20230306;

import java.util.concurrent.Semaphore;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 17:19
 */
public class H2O {

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(1);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        releaseOxygen.run();
        h.release(2);
    }
}
