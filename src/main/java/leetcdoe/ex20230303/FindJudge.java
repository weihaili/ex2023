package leetcdoe.ex20230303;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/3 15:16
 */
public class FindJudge {

    public static void main(String[] args) {
        FindJudge demo = new FindJudge();
        int num = demo.findJudge1(3, new int[][]{{1, 3},{2,3}});
        System.out.println(num);
    }

    public int findJudge1(int n, int[][] trust) {
        int[] trusted = new int[n];
        for (int[] nums : trust) {
            trusted[nums[0] - 1]--;
            trusted[nums[1] - 1]++;
        }
        for (int i = 0; i < n; ++i) {
            if (trusted[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] ints : trust) {
            int i = ints[0];
            int y = ints[1];
            ++inDegrees[y];
            ++outDegrees[i];
        }
        for (int i = 1; i <= n; ++i) {
            if (inDegrees[i] == n -1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
