package leetcdoe.ex202302017;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/17 16:06
 */
public class RangeBitwiseAnd {

    public static void main(String[] args) {
        RangeBitwiseAnd demo = new RangeBitwiseAnd();
        int cnt = demo.rangeBitwiseAnd(5, 7);
        System.out.println(cnt);
    }

    public int rangeBitwiseAnd(int left, int right) {
        int num  = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++num;
        }
        return left << num;
    }

    public int rangeBitwiseAnd2(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }

    public int rangeBitwiseAnd1(int left, int right) {
        String lStr = Integer.toBinaryString(left);
        String rStr = Integer.toBinaryString(right);
        int len = lStr.length();
        int ren = rStr.length();
        if (len > ren) {
            lStr= lStr.substring(len - ren - 1, ren);
        }
        if (len < ren) {
            rStr= lStr.substring(ren - len - 1, len);
        }
        int length = Math.min(len, ren);
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            if (lStr.charAt(i) == rStr.charAt(i) && lStr.charAt(i) == '1') {
                buf.append(1);
            } else {
                buf.append(0);
            }
        }
        if (buf.length() > 0) {
            return Integer.parseInt(buf.toString(), 2);
        }
        return 0;
    }
}
