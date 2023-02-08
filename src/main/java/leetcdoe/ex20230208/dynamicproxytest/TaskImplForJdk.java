package leetcdoe.ex20230208.dynamicproxytest;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/8 10:42
 */
public class TaskImplForJdk implements TaskInterfaceForJdk{

    @Override
    public void setData(String data) {
        System.out.println(data + "data is saved");
    }

    @Override
    public int getCalData(int x) {
        return x * 10;
    }
}
