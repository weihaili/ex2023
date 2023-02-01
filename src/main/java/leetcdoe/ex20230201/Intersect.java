package leetcdoe.ex20230201;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/1 10:29
 */
public class Intersect {
    public static void main(String[] args) {
        Intersect demo = new Intersect();
        int[] nums1 = {1, 2};
        int[] nums2 = {1,1};
        int[] res = demo.intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] shortArr = len1 >= len2 ? nums2 : nums1;
        int[] longArr = len1 >= len2 ? nums1 : nums2;
        Map<Integer, Integer> rules = new HashMap<>(shortArr.length << 1);
        for (int num : shortArr) {
            rules.put(num, rules.getOrDefault(num, 0) + 1);
        }
        int[] intersection = new int[shortArr.length];
        int repeatCount = 0;
        for (int num : longArr) {
            int times = rules.getOrDefault(num, 0);
            if (times > 0) {
                intersection[repeatCount++] = num;
                times--;
                if (times > 0) {
                    rules.put(num, times);
                } else {
                    rules.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, repeatCount);
    }
}
