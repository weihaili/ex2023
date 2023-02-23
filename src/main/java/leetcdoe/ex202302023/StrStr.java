package leetcdoe.ex202302023;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/23 17:29
 */
public class StrStr {

    public static void main(String[] args) {
        StrStr demo = new StrStr();
        int idx = demo.strStr("leetcode", "leeto");
        System.out.println(idx);
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0) {
            return -1;
        }
        return haystack.indexOf(needle);
    }
}
