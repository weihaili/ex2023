package lnitcode.ex20230308;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 15:13
 */
public class SumofTwoStrings {

    public static void main(String[] args) {
        SumofTwoStrings demo = new SumofTwoStrings();
        String str = demo.sumofTwoStrings("2", "321");
        System.out.println(str);
    }

    public String sumofTwoStrings(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        int alen = a.length();
        int blen = b.length();
        if (alen < blen) {
            return sumofTwoStrings(b, a);
        }
        int dif = alen - blen;
        StringBuilder buf = new StringBuilder(a.substring(0, dif));
        for (int i = 0; i < alen - dif; i++) {
            buf.append(a.charAt(dif + i) - 48 + b.charAt(i) - 48);
        }
        return buf.toString();
    }

    public String sumofTwoStrings2(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        int carry = 0;
        int aidx = a.length() - 1;
        int bidx = b.length() - 1;
        StringBuilder buf = new StringBuilder();
        while (aidx >=0 || bidx >= 0) {
            int aval = 0;
            if (aidx >= 0) {
                aval = a.charAt(aidx) - 48;
            }
            int bval = 0;
            if (bidx >= 0) {
                bval = b.charAt(bidx) - 48;
            }
            int sum = aval + bval + carry;
            carry = sum > 9 ? 1 : 0;
            buf.append(sum % 10);
            --aidx;
            --bidx;
        }
        if (carry > 0) {
            buf.append(carry);
        }
        return buf.reverse().toString();
    }

    public String sumofTwoStrings1(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        return String.valueOf(Integer.valueOf(a) + Integer.valueOf(b));
    }
}
