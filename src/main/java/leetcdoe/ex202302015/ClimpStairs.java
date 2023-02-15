package leetcdoe.ex202302015;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 15:43
 */
public class ClimpStairs {

    public static void main(String[] args) {
        ClimpStairs demo = new ClimpStairs();
        int ways = demo.climb(10);
        System.out.println(ways);
    }

    private int climb(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 3) {
            return n;
        }
        int pre = 1;
        int cur = 2;
        int next = pre + cur;
        for (int i = 4; i <= n; ++i) {
            pre = cur;
            cur = next;
            next = pre + cur;
        }
        return next;
    }

    private int climb1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
