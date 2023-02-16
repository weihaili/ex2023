package leetcdoe.ex202302016;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/16 14:08
 */
public class EraseOverlapIntervals {

    public static void main(String[] args) {
        EraseOverlapIntervals demo = new EraseOverlapIntervals();
        int[][] matrix = {{1,2},{2,3},{3,4},{1,3}};
        int cnt = demo.eraseOverlapIntervals(matrix);
        System.out.println(cnt);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return 0;
        }
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int rn = intervals[0][1];
        int res = 1;
        for (int i = 1; i < len; ++i) {
            if (intervals[i][0] >= rn) {
                ++res;
                rn = intervals[i][1];
            }
        }
        return len - res;
    }
}
