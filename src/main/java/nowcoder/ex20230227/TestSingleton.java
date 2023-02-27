package nowcoder.ex20230227;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 15:14
 */
public class TestSingleton {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonEnum instance = SingletonEnum.SINGLETON_ENUM_10;
                System.out.println(instance.hashCode());
                for (int i = 0; i < 10; i++) {
                    instance.test();
                    System.out.println(instance.getCount());
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonEnum instance = SingletonEnum.SINGLETON_ENUM_10;
                System.out.println(instance.hashCode());
                for (int i = 0; i < 10; i++) {
                    instance.test();
                    System.out.println(instance.getCount());
                }
            }
        });

        t1.start();
        t2.start();
        System.out.println(SingletonEnum.SINGLETON_ENUM_10.hashCode());
        System.out.println(SingletonEnum.SINGLETON_ENUM_10.getCount());
    }

}
