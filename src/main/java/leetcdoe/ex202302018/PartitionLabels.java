package leetcdoe.ex202302018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/20 15:18
 */
public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels demo = new PartitionLabels();
        List<Integer> ans = demo.partitionLabels("eccbbbbdec");
        System.out.println(Arrays.toString(ans.toArray()));
    }

    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int len = s.length();
        int[] lastIdxArr = new int[26];
        for (int i = 0; i < len; i++) {
            lastIdxArr[s.charAt(i) - 'a'] = i;
        }
        int startIdx = 0;
        int endIdx = 0;
        for (int i = 0; i < s.length(); ++i) {
            endIdx = Math.max(endIdx, lastIdxArr[s.charAt(i) - 'a']);
            if (i == endIdx) {
                ans.add(endIdx - startIdx + 1);
                startIdx = endIdx + 1;
            }
        }
        return ans;
    }
}
