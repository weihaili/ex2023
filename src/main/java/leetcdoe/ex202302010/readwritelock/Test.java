package leetcdoe.ex202302010.readwritelock;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 9:41
 */
public class Test {

    public static void main(String[] args) {

        CyclicBarrier cb;

        CountDownLatch cdl;

        Thread t;

        ThreadLocal tl;

        SoftReference sr;

        WeakReference wr;

        PhantomReference pr;
    }
}
