package leetcdoe.ex202302028;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 16:40
 */
public class SortArray {
    public static void main(String[] args) {
        SortArray demo = new SortArray();
        int[] res = demo.sortArray(new int[]{0,1,3,2});
        System.out.println(Arrays.toString(res));
    }

    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
