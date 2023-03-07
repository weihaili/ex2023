package leetcdoe.ex20230307;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 16:51
 */
public class LowercaseToUppercase {

    public static void main(String[] args) {
        int a = 'a';
        int A = 'A';
        System.out.println(a);
        System.out.println(A);
        LowercaseToUppercase demo = new LowercaseToUppercase();
        char c = demo.lowercaseToUppercase('b');
        System.out.println(c);
    }

    public char lowercaseToUppercase(char character) {
        return character &= -33;
    }
}
