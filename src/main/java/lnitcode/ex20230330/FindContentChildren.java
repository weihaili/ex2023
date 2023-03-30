package lnitcode.ex20230330;

import java.util.Arrays;

public class FindContentChildren {

    public static void main(String[] args) {
        FindContentChildren demo = new FindContentChildren();
        int cnt = demo.findContentChildren(new int[]{1,2}, new int[]{1, 2, 3});
        System.out.println(cnt);
    }

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int idxg = 0;
        int idxs = 0;
        int cnt = 0;
        while (idxg < g.length && idxs < s.length) {
            int numg = g[idxg];
            int nums = s[idxs];
            if (nums >= numg) {
                ++cnt;
                ++idxg;
                ++idxs;
            } else {
                ++idxs;
            }
        }
        return cnt;
    }
}
