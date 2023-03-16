package lnitcode.ex20230316;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 17:16
 */
public class GetWays {

    public static void main(String[] args) {
        GetWays demo = new GetWays();
        int ways = demo.getWays(new int[]{1,2,3}, 2);
        System.out.println(ways);

    }

    public int getWays(int[] a, int k) {
        if (a == null || a.length < k) {
            return 0;
        }
        return dfs(a, k, 0, 0, 0);
    }

    private int dfs(int[] a, int k, int idx, int pickCnt, int sum) {
        if (pickCnt == k) {
            return isPrime(sum) ? 1 : 0;
        }
        if (idx >= a.length) {
            return 0;
        }
        int count = 0;
        count += dfs(a, k, idx + 1, pickCnt + 1, sum + a[idx]);
        count += dfs(a, k, idx + 1, pickCnt, sum);
        return count;
    }

    private boolean isPrime(int num) {
        boolean primeFlag = false;
        if (num < 2) {
            return primeFlag;
        }
        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                return primeFlag;
            }
        }
        return true;
    }
}
