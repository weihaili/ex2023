package leetcdoe.ex20230202;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/2 14:15
 */
public class IntervalIntersection {

    public static void main(String[] args) {
        IntervalIntersection demo = new IntervalIntersection();
        int[][] first = {};
        int[][] second = {{1,5},{8, 12},{15, 24},{25, 26}};
        int[][] intersection = demo.intervalIntersection(first, second);
        if (intersection == null) {
            System.out.println("intersection is null");
        }
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < intersection.length; i++) {
            if (buf.length() > 0) {
                buf.delete(0, buf.length());
            }
            for (int j = 0; j < intersection[0].length; j++) {
                buf.append(" ").append(intersection[i][j]);
            }
            System.out.println(buf.toString());
        }
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
            return new int[0][0];
        }
        int fIdx = 0;
        int sIdx = 0;
        List<int[]> list = new ArrayList<>();
        while (fIdx < firstList.length && sIdx < secondList.length) {
            int floor = Math.max(firstList[fIdx][0], secondList[sIdx][0]);
            int ceiling = Math.min(firstList[fIdx][1], secondList[sIdx][1]);
            if (floor <= ceiling) {
                list.add(new int[]{floor, ceiling});
            }
            if (firstList[fIdx][1] < secondList[sIdx][1]) {
                fIdx++;
            } else {
                sIdx++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
