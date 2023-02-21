package leetcdoe.ex202302021;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 11:14
 */
public class AddStrings {

    public static void main(String[] args) {
        AddStrings demo = new AddStrings();
        String res = demo.addStrings("0", "0");
        System.out.println(res);
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null && num2 != null) {
            return num2;
        }
        if (num1 != null && num2 == null) {
            return num1;
        }
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int carry = 0;
        StringBuilder buf = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0 || carry > 0) {
            int x = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int y = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            int sum = x + y + carry;
            buf.append(sum % 10);
            carry = sum / 10;
            --idx1;
            --idx2;
        }
        buf.reverse();
        return buf.toString();
    }
}
