package leetcdoe.ex202302014.threadtest;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/14 10:21
 */
public class ConsumerForYield extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            System.out.println("I am consumer thread : " + i);
        }
    }
}
