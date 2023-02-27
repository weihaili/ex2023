package nowcoder.ex20230227;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 15:34
 */
public class DeathLock {

    public void test1() {
        synchronized (String.class){
            System.out.println("aquired lock on String.class object");
            synchronized (Integer.class) {
                System.out.println("aquired lock on Integer.class object");
            }
        }
    }

    public void test2() {
        synchronized (Integer.class){
            System.out.println("aquired lock on integer.class object");
            synchronized (String.class) {
                System.out.println("aquired lock on string.class object");
            }
        }
    }
}
