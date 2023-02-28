package nowcoder.ex20230228;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 18:54
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        ReplaceSpace demo = new ReplaceSpace();
        String str = demo.replaceSpace("We Are Happy");
        System.out.println(str);
    }

    public String replaceSpace (String s) {
        return s.replaceAll(" ", "%20");
    }
}
