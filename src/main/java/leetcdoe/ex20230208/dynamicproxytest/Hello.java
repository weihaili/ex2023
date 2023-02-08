package leetcdoe.ex20230208.dynamicproxytest;

/**
 * Description: cglib dynamic proxy target class
 *
 * @author Admin
 * @date 2023/2/8 10:07
 */
public class Hello {

    public String sayHello(boolean throwException) throws Exception {
        System.out.println("hello everyone!");
        if (throwException) {
            throw new Exception("test exception");
        }
        return  "cglib dynamic proxy target class";
    }
}
