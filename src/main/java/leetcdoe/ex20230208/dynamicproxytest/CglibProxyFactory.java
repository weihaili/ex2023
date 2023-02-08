package leetcdoe.ex20230208.dynamicproxytest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/8 10:10
 */
public class CglibProxyFactory implements MethodInterceptor {

    /**
     * need to proxy original object
     */
    private Object obj;

    public Object createProxy(Object target) {
        this.obj = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.obj.getClass());
        enhancer.setCallback(this);
        enhancer.setClassLoader(target.getClass().getClassLoader());
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object res = null;
        try {
            befor();
            res = proxy.invokeSuper(obj, args);
            after();
        } catch (Throwable e) {
            excepton();
        } finally {
            beforeReturning();
        }
        return res;
    }

    private void befor() {
        System.out.println("proxy invoke target method before enhance");
    }

    private void after() {
        System.out.println("proxy invoke target method after enhance");
    }

    private void excepton() {
        System.out.println("proxy invoke target method exceptoin enhance");
    }

    private void beforeReturning() {
        System.out.println("proxy invoke target method beforeReturning enhance");
    }
}
