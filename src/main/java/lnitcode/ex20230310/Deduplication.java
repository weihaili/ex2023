package lnitcode.ex20230310;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/10 15:45
 */
public class Deduplication {

    public static void main(String[] args) {
        Deduplication demo = new Deduplication();
        int cnt = demo.deduplication(new int[]{1,3,1,4,4,2});
        System.out.println(cnt);
    }

    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])) {
                nums[cnt++] = nums[i];
            }
        }

        return cnt;
    }
}
