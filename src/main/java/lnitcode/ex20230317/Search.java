package lnitcode.ex20230317;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 14:46
 */
public class Search {

    public static void main(String[] args) {
        Search demo = new Search();
        boolean flag = demo.search(new int[]{0,1,2,3,4, 7,8}, 5);
        System.out.println(flag);
    }

    public boolean search(int[] a, int target) {
        if (a == null || a.length == 0) {
            return false;
        }
        Arrays.sort(a);
        int idx = Arrays.binarySearch(a, target);
        return idx >= 0 ;
    }
}
