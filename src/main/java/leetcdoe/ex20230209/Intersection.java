package leetcdoe.ex20230209;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 14:56
 */
public class Intersection {
    public static void main(String[] args) {
        Intersection demo = new Intersection();
        int[] res = demo.intersection(new int[]{1,2,2,1}, new int[]{2,2});
        System.out.println(Arrays.toString(res));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> unique = new HashSet<>();
        for (int num : nums1) {
            unique.add(num);
        }
        Set<Integer> resUnique = new HashSet<>(unique.size());
        for (int num : nums2) {
            if (unique.contains(num)) {
                resUnique.add(num);
            }
        }
        return resUnique.stream().mapToInt(num -> num).toArray();
    }
}
