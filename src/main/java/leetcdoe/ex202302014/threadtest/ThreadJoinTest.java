package leetcdoe.ex202302014.threadtest;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/14 10:41
 */
public class ThreadJoinTest {

    public static void main(String[] args) {
        ThreadJoinTest demo = new ThreadJoinTest();
        demo.testJoin();
    }

    private void testJoin() {
        System.out.println("thread name:" + Thread.currentThread().getName() + "execute start");
        Thread joinB = new ThreadForJoinB();

        Thread joinC = new Thread(new ThreadForJoinC());
        joinB.start();
        joinC.start();
        try {
            joinB.join();
            joinC.join();
        } catch (InterruptedException e) {
            System.out.println("testJoin InterruptedException");
            throw new RuntimeException(e);
        }
        System.out.println("thread name:" + Thread.currentThread().getName() + "execute end");
    }
}
