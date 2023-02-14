package leetcdoe.ex202302014;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/14 15:35
 */
public class Merge {

    public static void main(String[] args) {
        Merge demo = new Merge();
        int[][] res = demo.merge(new int[][]{{1,3},{4,5},{6,7},{8,9},{1,10}});
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Stack<int[]> stack = new Stack<>();
        for (int[] nums : intervals) {
            if (stack.isEmpty()) {
                stack.push(nums);
                continue;
            }
            int[] peek = stack.peek();
            if (peek[1] < nums[0]) {
                stack.push(nums);
                continue;
            }
            if (peek[0] > nums[0] && peek[0] > nums[1]) {
                stack.push(nums);
                continue;
            }
            int[] pop = stack.pop();
            stack.push(new int[]{Math.min(pop[0], nums[0]), Math.max(pop[1], nums[1])});
        }
        int size = stack.size();
        int[][] res = new int[size][2];
        while (!stack.isEmpty()) {
            res[--size] = stack.pop();
        }
        return res;
    }
}
