package leetcdoe.ex20230209;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 14:18
 */
public class Search {

    public static void main(String[] args) {
        Search demo = new Search();
        int[] nums = {1,2,3,5,7,9,10};
        int idx = demo.search(nums, 5);
        System.out.println(idx);
    }

    public int search(int[] nums, int target) {
        int res = -1;
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        int lidx = 0;
        int ridx = len - 1;
        while (lidx <= ridx) {
            int midx = (lidx + ridx) >> 1;
            int mval = nums[midx];
            if (target == mval) {
                return midx;
            } else if (target > mval) {
                lidx = ++midx;
            } else {
                ridx = --midx;
            }
        }
        return res;
    }
}
