package lnitcode.ex20230317;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 10:13
 */
public class SingletonTest {

    public static void main(String[] args) {
        SingletonTest demo = new SingletonTest();
        demo.test();
    }

    private void test() {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    Solution sl = Solution.getInstance();
                    System.out.println("s1 hashCode: " + sl.hashCode());

                    Singleton instance = Singleton.INSTANCE;
                    System.out.println("instance hashCode: " + instance.hashCode());
                }
            });
        }
    }
}
