package lnitcode.ex20230328;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates demo = new RemoveDuplicates();
        int[] params = {};
        int[] params1 = {1,1,1, 1, 1,2,2, 2, 3,3};
        int[] params2 = {-8,0,1,2,3};
        int len = demo.removeDuplicates(params2);
        System.out.println(len);
    }

    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        if (nums == null) {
            return cnt;
        }
        int len = nums.length;
        if (len < 3) {
            return len;
        }
        int times = 2;
        for (int i = 1; i < len; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[cnt++] = nums[i];
                times = 2;
            } else {
                --times;
                if (times > 0) {
                    nums[cnt++] = nums[i];
                }
            }
        }
        return cnt + 1;
    }

    public int removeDuplicates3(int[] nums) {
        int cnt = 0;
        if (nums == null) {
            return cnt;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (cnt < 2 || nums[i] != nums[cnt - 2]) {
                nums[cnt++] = nums[i];
            }
        }
        return cnt;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len < 3) {
            return len;
        }
        int slowIdx = 2;
        int fastIdx = 2;
        while (fastIdx < len) {
            if (nums[slowIdx - 2] != nums[fastIdx]) {
                nums[slowIdx] = nums[fastIdx];
                ++slowIdx;
            }
            ++fastIdx;
        }
        return slowIdx;
    }

    public int removeDuplicates1(int[] nums) {
        int cnt = 0;
        if (nums == null || nums.length == 0) {
            return cnt;
        }
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        int times = 2;
        for (int i = 0; i < len; ++i) {
            int num = nums[i];
            if (i == 0) {
                list.add(cnt, num);
                ++cnt;
                continue;
            }
            int sNum = list.get(cnt - 1);
            if (sNum == num) {
                --times;
                if (times > 0) {
                    list.add(cnt, num);
                    ++cnt;
                }
            }
            if (sNum != num) {
                list.add(cnt, num);
                ++cnt;
                times = 2;
            }
        }
        cnt = list.size();
        int[] temp = list.stream().mapToInt(Integer::intValue).toArray();
        System.arraycopy(temp, 0, nums, 0, cnt);
        return cnt;
    }
}
