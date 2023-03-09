package lnitcode.ex20230309;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/9 10:03
 */
public class TrapRainWater {

    public static void main(String[] args) {
        TrapRainWater demo = new TrapRainWater();
        int capacity = demo.trapRainWater(new int[]{0, 2, 0, 1, 2, 1, 0});
        System.out.println(capacity);
    }

    public int trapRainWater(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int sum = 0;
        int len = heights.length;
        int[] maxL = new int[len];
        int[] maxR = new int[len];
        for (int i = 1; i < len; i++) {
            maxL[i] = Math.max(maxL[i - 1], heights[i - 1]);
        }
        for (int i = len - 2; i >= 0; --i) {
            maxR[i] = Math.max(maxR[i + 1], heights[i + 1]);
        }
        for (int i = 0; i < len; ++i) {
            int min = Math.min(maxL[i], maxR[i]);
            if (min > heights[i]) {
                sum += min - heights[i];
            }
        }
        return sum;
    }
}
