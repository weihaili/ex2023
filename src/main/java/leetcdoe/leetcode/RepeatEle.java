package leetcdoe.leetcode;

import java.util.HashMap;
import java.util.Map;


public class RepeatEle {

    public static void main(String[] args) {
        RepeatEle demo = new RepeatEle();
        int[] nums =  {1,2,3,10};
        boolean res = demo.containsDuplicate(nums);
        System.out.println(res);
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count != null) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }
}
