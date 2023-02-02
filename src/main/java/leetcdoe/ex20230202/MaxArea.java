package leetcdoe.ex20230202;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/2 14:59
 */
public class MaxArea {

    public static void main(String[] args) {
        MaxArea demo = new MaxArea();
        int[] nums = {1,2,3,4,5,6};
        int area = demo.maxArea(nums);
        System.out.println(area);
    }

    public int maxArea(int[] height) {
        int area = 0;
        if (height == null || height.length == 0) {
            return area;
        }
        int lIdx = 0;
        int rIdx = height.length - 1;
        while (lIdx < rIdx) {
            area = Math.max(area, Math.min(height[lIdx], height[rIdx])* (rIdx - lIdx));
            if (height[lIdx] <= height[rIdx]) {
                ++lIdx;
            } else {
                --rIdx;
            }
        }
        return area;
    }


    /**
     * timeOut
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int area = 0;
        if (height == null || height.length == 0) {
            return area;
        }
        for (int i = 0; i < height.length; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                area = Math.max(area, Math.min(height[i] , height[j]) * (j - i));
            }
        }
        return area;
    }
}
