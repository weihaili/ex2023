package leetcdoe.ex202302028;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 16:53
 */
public class smallestTrimmedNumbers {

    public static void main(String[] args) {
        smallestTrimmedNumbers demo = new smallestTrimmedNumbers();
        int[] idxs = demo.smallestTrimmedNumbers(new String[]{"102","473","251","814"},
            new int[][]{{1, 1},{2, 3},{4, 2},{1, 2}});
        System.out.println(Arrays.toString(idxs));
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int strLen = nums[0].length();
        for (int i = 0; i < queries.length; ++i) {
            int[] query = queries[i];
            List<Integer> idx = new ArrayList<>(Arrays.asList(IntStream.range(0, nums.length).boxed().toArray(Integer[]::new)));
            Collections.sort(idx, (m, n) -> nums[m].substring(strLen - query[1]).compareTo(nums[n].substring(strLen - query[1])));
            ans[i] = idx.get(query[0] - 1);
        }
        return ans;
    }


    public int[] smallestTrimmedNumbers1(String[] nums, int[][] queries) {
        if (queries == null || queries.length == 0) {
            return new int[0];
        }
        int len = queries.length;
        int[] idxs = new int[len];
        int numLen = nums.length;
        for (int i = 0; i < len ; ++i) {
            int[] query = queries[i];
            int k = query[0];
            int bits = query[1];
            int[] temp = new int[numLen];
            for (int j = 0; j < numLen; ++j) {
                String num = nums[j];
                int strLen = num.length();
                temp[j] = Integer.parseInt(num.substring(strLen - bits, strLen));
            }
            int idx = getKminIdx(temp, k);
            idxs[i] = idx;
        }
        return idxs;
    }

    private int getKminIdx(int[] temp, int k) {
        int[] newTemp = Arrays.copyOf(temp, temp.length);
        Arrays.sort(temp);
        int num = newTemp[k - 1];
        for (int i = 0; i < temp.length; ++i) {

        }
        return 0;
    }
}
