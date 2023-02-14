package leetcdoe.ex202302013;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/13 9:46
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement demo = new MajorityElement();
        int num = demo.majorityElement2(new int[]{2,2,2,2,1,1,1});
        System.out.println(num);
    }

    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 0;
        int candidate = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }
            cnt += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public int majorityElement1(int[] nums) {
        int eleVla = 0;
        if (nums == null || nums.length == 0) {
            return eleVla;
        }
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    public int majorityElement(int[] nums) {
        int eleVla = 0;
        if (nums == null || nums.length == 0) {
            return eleVla;
        }
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len >> 1);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (len >> 1)) {
                eleVla =  entry.getKey();
                break;
            }
        }
        return eleVla;
    }
}
