package leetcdoe.ex202302014.threadtest;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/14 10:23
 */
public class ProducerForYield extends Thread {

    public void run() {
        for (int i = 0; i < 5; ++i) {
            System.out.println("I am producer Thread: " + i);
            Thread.yield();
        }
    }
}
