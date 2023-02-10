package leetcdoe.ex202302010.readwritelock;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 15:23
 */
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert demo = new SearchInsert();
        int[] nums = {1, 3, 5, 6};
        int idx = demo.searchInsert(nums, 7);
        System.out.println(idx);
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idxS = 0;
        int idxE = nums.length - 1;
        while (idxS <= idxE) {
            int idxM = idxS + ((idxE - idxS) >> 1);
            int curv = nums[idxM];
            if (curv == target) {
                return idxM;
            } else if (curv > target) {
                idxE = idxM - 1;
            } else {
                idxS = idxS + 1;
            }
        }
        return idxS;
    }
}
