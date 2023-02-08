package leetcdoe.ex20230208.dynamicproxytest;

import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/8 10:49
 */
public class MyProxyFactoryForJdkDynamic {

    public static Object newInstance(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                new Class<?>[] {TaskInterfaceForJdk.class},
                new MyInvokationHandler(obj));
    }
}
