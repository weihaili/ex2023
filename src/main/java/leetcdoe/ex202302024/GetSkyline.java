package leetcdoe.ex202302024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 14:21
 */
public class GetSkyline {
    public static void main(String[] args) {
        GetSkyline demo = new GetSkyline();
        List<List<Integer>> res = demo.getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}});
        for (List<Integer> re : res) {
            System.out.println(Arrays.asList(re.toArray()));
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) ->b[1] - a[1]);
        List<Integer> boundries = new ArrayList<>();
        for (int[] boundry : buildings) {
            boundries.add(boundry[0]);
            boundries.add(boundry[1]);
        }
        Collections.sort(boundries);
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        int len = buildings.length;
        for (int boundry : boundries) {
            while (idx < len && buildings[idx][0] <= boundry) {
                que.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                ++idx;
            }
            while (!que.isEmpty() && que.peek()[0] <= boundry) {
                que.poll();
            }
            int max = que.isEmpty() ? 0 : que.peek()[1];
            if (res.size() == 0 || max != res.get(res.size() - 1).get(1)) {
                res.add(Arrays.asList(boundry, max));
            }
        }
        return res;
    }
}
