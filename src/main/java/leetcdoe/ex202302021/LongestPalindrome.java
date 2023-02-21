package leetcdoe.ex202302021;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 10:59
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome demo = new LongestPalindrome();
        int cnt = demo.longestPalindrome("aaaaaccc");
        System.out.println(cnt);
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] cnt = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i)];
        }
        int res = 0;
        for (int num : cnt) {
            res += num >> 1 << 1;
            if ((num & 1) == 1 && (res & 1) != 1) {
                ++res;
            }
        }
        return res;
    }
}
