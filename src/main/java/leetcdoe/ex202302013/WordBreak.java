package leetcdoe.ex202302013;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/13 13:51
 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak demo = new WordBreak();
        List<String> dic = new ArrayList<>();
        dic.add("leet");
        dic.add("codee");
        dic.add("rs");
        boolean flag = demo.wordBreak("leetcode", dic);
        System.out.println(flag);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || (s.length() != 0 && wordDict.size() == 0)) {
            return false;
        }
        Set<String> dicSet = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && dicSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s == null || wordDict == null || (s.length() != 0 && wordDict.size() == 0)) {
            return false;
        }
        String tempStr = s;
        for (String str : wordDict) {
            tempStr = tempStr.replaceAll(str, "");
        }
        return tempStr.length() == 0;
    }
}
