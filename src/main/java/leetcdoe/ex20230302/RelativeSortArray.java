package leetcdoe.ex20230302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 18:31
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        RelativeSortArray demo = new RelativeSortArray();
        int[] res = demo.relativeSortArray(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31
},
            new int[]{2,42,38,0,43,21});
        System.out.println(Arrays.toString(res));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return new int[0];
        }
        List<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> valCntMap = new HashMap<>();
        for (int i = 0; i < arr1.length; ++i) {
            valCntMap.put(arr1[i], valCntMap.getOrDefault(arr1[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<Integer>();
        int idx = 0;
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr2.length; ++i) {
            int num = arr2[i];
            int cnt = valCntMap.get(num);
            for (int j = 0; j < cnt; ++j) {
                res[idx] = num;
                ++idx;
            }
            set.add(num);
        }
        Set<Integer> keys = valCntMap.keySet();
        for (Integer key : keys) {
            if (!set.contains(key)) {
                int cnt = valCntMap.get(key);
                for (int j = 0; j < cnt; ++j) {
                    nums.add(key);
                }
            }
        }

        if (nums.size() > 0) {
            Collections.sort(nums);
        }
        for (Integer num : nums) {
            res[idx] = num;
            ++idx;
        }
        return res;
    }
}
