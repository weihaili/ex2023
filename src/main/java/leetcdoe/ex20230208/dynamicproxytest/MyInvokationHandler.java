package leetcdoe.ex20230208.dynamicproxytest;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/8 10:43
 */
public class MyInvokationHandler implements InvocationHandler {

    private Object obj;

    public MyInvokationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().contains("get")) {
            System.out.println("...get method executing...");
        } else {
            System.out.println("...set method executing...");
        }
        return method.invoke(obj, args);
    }
}
