package leetcdoe.ex20230302;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 14:19
 */
public class NativeTest {

    static{
        System.loadLibrary("hello");
    }

    public native void sayHello();

    public static void main(String[] args) {
        new NativeTest().sayHello();
    }

}
