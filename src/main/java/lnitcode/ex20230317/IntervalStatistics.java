package lnitcode.ex20230317;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 13:48
 */
public class IntervalStatistics {

    public static void main(String[] args) {
        IntervalStatistics demo = new IntervalStatistics();
        long cnt = demo.intervalStatistics(new int[]{1,1,1,1,1,0,0,1,0,1,0,0,0,1,0,0,0}, 0);
        System.out.println(cnt);
    }

    public long intervalStatistics(int[] arr, int k) {
        long cnt = 0;
        if (arr == null || arr.length ==0) {
            return 0;
        }
        int len = arr.length;
        int idx = 0;
        while (arr[idx] != 0) {
            ++idx;
            continue;
        }
        int j = idx;
        int count = 0;
        for (int i = idx; i < len; ++i) {
            if (arr[i] != 0) {
                --count;
                continue;
            }
            while (j < len && count <= k) {
                if (arr[j] != 0) {
                    ++count;
                }
                j++;
            }
            cnt += j - i - count;
        }
        return cnt;
    }
}
