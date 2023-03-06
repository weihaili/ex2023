package leetcdoe.ex20230306;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 17:26
 */
public class FizzBuzz {

    private Semaphore number = new Semaphore(1);
    private Semaphore three = new Semaphore(0);

    private Semaphore five = new Semaphore(0);

    private Semaphore fifteen = new Semaphore(0);
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            three.acquire();
            if (i % 5 == 0) {
                continue;
            }
            printFizz.run();
            number.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            five.acquire();
            if (i % 3 == 0) {
                continue;
            }
            printBuzz.run();
            number.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            fifteen.acquire();
            printFizzBuzz.run();
            number.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            number.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                fifteen.release();
                three.release();
                five.release();
                continue;
            }
            if (i % 3 == 0) {
                three.release();
                continue;
            }
            if (i % 5 == 0) {
                five.release();
                continue;
            }
            printNumber.accept(i);
            number.release();
        }
    }
}
