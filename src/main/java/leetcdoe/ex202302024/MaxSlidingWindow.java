package leetcdoe.ex202302024;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 14:43
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        MaxSlidingWindow demo = new MaxSlidingWindow();
        int[] nums = demo.maxSlidingWindow(new int[]{1, 3, 6, 3, 4, 1, 7}, 3);
        System.out.println(Arrays.toString(nums));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!que.isEmpty() && nums[i] >= nums[que.peekLast()]) {
                que.pollLast();
            }
            que.offerLast(i);
        }
        res[0] = nums[que.peekFirst()];
        for (int i = k; i < nums.length; ++i) {
            while (!que.isEmpty() && nums[i] >= nums[que.peekLast()]) {
                que.pollLast();
            }
            que.offerLast(i);
            while (que.peekFirst() <= i - k) {
                que.pollFirst();
            }
            res[i - k + 1] = nums[que.peekFirst()];
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        int idx = 0;
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; ++i) {
            int max = nums[i];
            for (int j = i; j < i + k; ++j) {
                max = Math.max(max, nums[j]);
            }
            res[idx] = max;
            ++idx;
        }
        return res;
    }
}
