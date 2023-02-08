package leetcdoe.ex20230208.dynamicproxytest;

/**
 * Description: cglib dynamic cannot cast to original target class?--classCastException
 *
 * @author Admin
 * @date 2023/2/8 10:27
 */
public class CglibEnhanceTest {

    public static void main(String[] args) throws Exception {
        Hello hello = new Hello();
        CglibProxyFactory proxyFactory = new CglibProxyFactory();
        Hello proxy = (Hello)proxyFactory.createProxy(hello);
        String res = proxy.sayHello(true);
        System.out.println(res);
    }
}
