package leetcdoe.ex20230131;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/1/31 18:07
 */
public class CompressString {

    public static void main(String[] args) {
        CompressString demo = new CompressString();
        String res = demo.compressString("ab");
        System.out.println(res);
    }

    public String compressString(String S) {
        if (S == null || S.length() <= 2) {
            return S;
        }
        StringBuilder buf = new StringBuilder();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                buf.append(ch).append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        buf.append(ch).append(cnt);
        return buf.length() >= S.length() ? S : buf.toString();
    }
}
