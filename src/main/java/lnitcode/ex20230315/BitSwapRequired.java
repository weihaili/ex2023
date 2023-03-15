package lnitcode.ex20230315;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 8:52
 */
public class BitSwapRequired {

    public static void main(String[] args) {
        BitSwapRequired demo = new BitSwapRequired();
        int cnt = demo.bitSwapRequired(67, 31);
        System.out.println(cnt);
    }

    public int bitSwapRequired(int a, int b) {
        int cnt = 0;
        for (int i = 0; i < 32; ++i) {
            if ((a >> i & 1) != (b >> i & 1)) {
                ++cnt;
            }
        }
        return cnt;
    }

    public int bitSwapRequired1(int a, int b) {
        String aBStr = Integer.toBinaryString(a);
        String bBStr = Integer.toBinaryString(b);
        int digitDif = Math.abs(aBStr.length() - bBStr.length());
        for (int i = 0; i < aBStr.length() && i < bBStr.length(); ++i) {
            if (aBStr.charAt(i) != bBStr.charAt(i)) {
                ++digitDif;
            }
        }
        return digitDif;
    }
}
