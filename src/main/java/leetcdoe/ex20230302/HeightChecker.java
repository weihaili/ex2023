package leetcdoe.ex20230302;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 18:26
 */
public class HeightChecker {

    public static void main(String[] args) {
        HeightChecker demo = new HeightChecker();
        int cnt = demo.heightChecker(new int[]{5,1,2,3,4});
        System.out.println(cnt);
    }

    public int heightChecker(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] copyArr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copyArr);
        int cnt = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (heights[i] != copyArr[i]) {
                ++cnt;
            }
        }
        return cnt;
    }
}
