package leetcdoe.ex20230306;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 17:45
 */
public class DiningPhilosophers {

    public DiningPhilosophers() {

    }

    private final ReentrantLock[] locks = new ReentrantLock[]{
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()
    };

    private Semaphore eatLimit = new Semaphore(4);

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = (philosopher + 1) % 5;
        int rightFork = philosopher;

        eatLimit.acquire();

        locks[leftFork].lock();
        locks[rightFork].lock();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();
        putLeftFork.run();
        putRightFork.run();

        locks[leftFork].unlock();
        locks[rightFork].unlock();

        eatLimit.release();
    }
}
