package lnitcode.ex20230316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 16:37
 */
public class PalindromePairs {

    public static void main(String[] args) {
        PalindromePairs demo = new PalindromePairs();
        List<List<Integer>> res = demo.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }

    }

    public List<List<Integer>> palindromePairs(String[] words) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) {
            return res;
        }
        int length = words.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                if (palindromePairs(words[i] + words[j])) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private boolean palindromePairs(String str) {
        if (str == null) {
            return false;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len >> 1; i++) {
            if (chars[i] != chars[len -i - 1]) {
                return false;
            }
        }
        return true;
    }



    private boolean isPalindrome(String words) {
        if (words == null) {
            return false;
        }
        BitSet bs = new BitSet();
        for (char c : words.toCharArray()) {
            bs.flip(c);
        }
        return bs.cardinality() < 2;
    }
}
