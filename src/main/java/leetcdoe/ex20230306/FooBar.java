package leetcdoe.ex20230306;

import java.util.concurrent.Semaphore;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 17:07
 */
public class FooBar {

    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}
