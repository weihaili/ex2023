package leetcdoe.ex20230208.dynamicproxytest;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/8 10:53
 */
public class JdkDynamicProxyTest {

    public static void main(String[] args) {
        TaskInterfaceForJdk task = (TaskInterfaceForJdk) MyProxyFactoryForJdkDynamic.newInstance(new TaskImplForJdk());
        task.setData("test");
        System.out.println("=================");
        System.out.println(task.getCalData(5));
    }
}
