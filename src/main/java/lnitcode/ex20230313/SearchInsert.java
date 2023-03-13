package lnitcode.ex20230313;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 10:37
 */
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert demo = new SearchInsert();
        int index = demo.searchInsert(new int[]{5}, 5);
        System.out.println(index);
    }

    public int searchInsert(int[] a, int target) {
        if (a == null || a.length == 0) {
            return 0;
        }
        if (a[0] >= target) {
            return 0;
        }

        int idx = Arrays.binarySearch(a, target);
        return idx > 0 ? idx : Math.abs(idx) - 1;
    }
}
