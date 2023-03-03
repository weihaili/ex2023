package leetcdoe.ex20230303;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/3 17:37
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        RelativeSortArray demo = new RelativeSortArray();
        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = {2,42,38,0,43,21};
        int[] nums = demo.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(nums));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return new int[0];
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }
        Map<Integer, Integer> numCntMap = new HashMap<>();
        for (int i : arr1) {
            numCntMap.put(i, numCntMap.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[arr1.length];
        int idx = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr2) {
            int cnt = numCntMap.get(i);
            for (int j = 0; j < cnt; ++j) {
                res[idx] = i;
                ++idx;
            }
            set.add(i);
        }
        Arrays.sort(arr1);
        int temp = 0;
        for (int num : arr1) {
            if (temp == num) {
                continue;
            }
            if (!set.contains(num)) {
                int cnt = numCntMap.get(num);
                for (int j = 0; j < cnt; ++j) {
                    res[idx] = num;
                    ++idx;
                }
            }
            temp = num;
        }
        return res;
    }
}
