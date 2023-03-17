package lnitcode.ex20230317;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 15:10
 */
public class GetDistance {

    public static void main(String[] args) {
        GetDistance demo = new GetDistance();
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 11, 14, 17, 21));
        int distance = demo.getDistance(5, 2, 25, list);
        System.out.println(distance);
    }

    public int getDistance(int n, int m, int target, List<Integer> d) {
        if (n == 0 && m == 0 && (d == null || d.size() == 0)) {
            return target;
        }
        d.add(target);
        int left = 1;
        int right = target;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (judge(mid, m, d)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean judge(int mid, int m, List<Integer> d) {
        int pre = 0;
        int count = 0;
        for (int i = 0; i < d.size(); ++i) {
            if (d.get(i) - pre < mid) {
                ++count;
            } else {
                pre = d.get(i);
            }
        }
        return count <= m;
    }
}
