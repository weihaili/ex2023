package lnitcode.ex20230308;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 13:55
 */
public class LowercaseToUppercase2 {

    public static void main(String[] args) {
        LowercaseToUppercase2 demo = new LowercaseToUppercase2();
        String res = demo.lowercaseToUppercase2("abC12");
        System.out.println(res);
    }

    public String lowercaseToUppercase2(String letters) {
        if (letters == null) {
            return letters;
        }
        return letters.toUpperCase();
    }
}
