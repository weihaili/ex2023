package lnitcode.ex20230308;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 13:49
 */
public class FindFirstStr {

    public static void main(String[] args) {
        FindFirstStr demo = new FindFirstStr();
        int idex = demo.strStr("", "");
        System.out.println(idex);
    }

    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        return source.indexOf(target);
    }
}
