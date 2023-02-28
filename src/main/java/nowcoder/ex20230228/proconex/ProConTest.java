package nowcoder.ex20230228.proconex;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 10:12
 */
public class ProConTest {

    public static void main(String[] args) {
        ProConTest demo = new ProConTest();
        demo.test();
    }

    private void test() {
        BufferArea bufa = new BufferArea(10);
        for (int i = 0; i < 3; ++i) {
            Thread thread = new Thread(new Producer(bufa));
            thread.setName("Producer—" + thread.getId());
            thread.start();
        }

        for (int i = 0; i < 9; ++i) {
            Thread thread = new Thread(new Consumer(bufa));
            thread.setName("Consumer-" + thread.getId());
            thread.start();
        }
    }
}
