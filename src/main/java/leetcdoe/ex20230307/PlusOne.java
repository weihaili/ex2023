package leetcdoe.ex20230307;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 18:52
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne demo = new PlusOne();
        int[] digits = new int[]{9, 9, 9};
        int[] res = demo.plusOne(digits);
        System.out.println(Arrays.toString(res));
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (!isCarry(digits[i], 1)) {
                digits[i] += 1;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] arr = new int[len + 1];
            arr[0] = 1;
            System.arraycopy(digits, 0, arr, 1, len);
            return arr;
        }
        return digits;
    }

    private boolean isCarry(int num, int addendum) {
        return num + addendum > 9;
    }

}
