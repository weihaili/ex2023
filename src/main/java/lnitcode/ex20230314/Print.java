package lnitcode.ex20230314;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 17:50
 */
public class Print implements InterfaceA, InterfaceB {

    public static void main(String[] args) {
        Print demo = new Print();
        demo.printCapitalLetter();
        demo.printLowercaseLetter();
    }

    @Override
    public void printCapitalLetter() {
        char temp = 'A';
        StringBuilder buf = new StringBuilder();
        while (temp <= 'Z') {
            buf.append(' ').append(temp);
            ++temp;
        }
        System.out.println(buf.substring(1));
    }

    @Override
    public void printLowercaseLetter() {
        char temp = 'a';
        StringBuilder buf = new StringBuilder();
        while (temp <= 'z') {
            buf.append(' ').append(temp);
            ++temp;
        }
        System.out.println(buf.substring(1));
    }
}

interface InterfaceA {
    void printCapitalLetter();
}

interface InterfaceB {
    void printLowercaseLetter();
}
