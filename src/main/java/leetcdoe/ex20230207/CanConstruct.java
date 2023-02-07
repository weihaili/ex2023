package leetcdoe.ex20230207;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/7 15:13
 */
public class CanConstruct {
    public static void main(String[] args) {
        CanConstruct demo = new CanConstruct();
        boolean flag = demo.canConstruct("aa", "aab");
        System.out.println(flag);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }
        int[] cnt = new int[26];
        char[] mChars = magazine.toCharArray();
        for (char ch : mChars) {
            ++cnt[ch - 'a'];
        }
        char[] rChars = ransomNote.toCharArray();
        for (char ch : rChars) {
            --cnt[ch - 'a'];
            if (cnt[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
