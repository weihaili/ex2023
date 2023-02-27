package nowcoder.ex20230227;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 14:52
 */
public class SingletonTest {

    private SingletonTest(){};

    private static SingletonTest instance = null;

    public static SingletonTest getInstance() {
        if (instance == null) {
            return new SingletonTest();
        }
        return instance;
    }
}

class SingletonTest1 {
    private SingletonTest1() {

    }

    private static SingletonTest1 instance = null;

    public static synchronized SingletonTest1 getInstance() {
        if (instance == null) {
            return new SingletonTest1();
        }
        return instance;
    }
}

class SingletonTest2 {

    private SingletonTest2() {

    }

    private static SingletonTest2 instance;

    public static SingletonTest2 getInstance() {
        synchronized (SingletonTest2.class) {
            if (instance == null) {
                return new SingletonTest2();
            }
            return instance;
        }
    }
}

class SingletonTest3 {
    private SingletonTest3() {

    }

    private volatile static SingletonTest3 instance = null;

    public static SingletonTest3 getInstance() {
        if (instance == null) {
            synchronized (SingletonTest3.class) {
                if (instance == null) {
                    instance = new SingletonTest3();
                }
            }
        }
        return instance;
    }
}

class SingletonTest4 {
    private SingletonTest4() {
    }

    private static class LazHolder {
        private static final SingletonTest4 INSTANCE = new SingletonTest4();
    }

    public static final SingletonTest4 getInstance() {
        return LazHolder.INSTANCE;
    }
}
