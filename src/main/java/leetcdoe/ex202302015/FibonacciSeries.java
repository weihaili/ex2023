package leetcdoe.ex202302015;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 15:26
 */
public class FibonacciSeries {

    public static void main(String[] args) {
        FibonacciSeries demo = new FibonacciSeries();
        int[] arr = demo.printPreNEle(11);
        System.out.println(Arrays.toString(arr));

        int n = demo.getEleN(11);
        System.out.println(n);
    }

    private int getEleN(int idx) {
        if (idx == 1) {
            return 0;
        }
        if (idx == 2) {
            return 1;
        }
        int idxPre = 0;
        int idxCur = 1;
        int next = idxPre + idxCur;
        for (int i = 4; i <= idx; ++i) {
            idxPre = idxCur;
            idxCur = next;
            next = idxPre + idxCur;
        }
        return next;
    }

    private int[] printPreNEle(int num) {
        if (num < 0) {
            return new int[0];
        }
        if (num == 0) {
            return new int[]{0};
        }
        if (num == 1) {
            return new int[]{0, 1};
        }
        int[] nums = new int[num];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i < num; ++i) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums;
    }
}
