package lnitcode.ex20230313;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 11:26
 */
public class GetAns {

    public static void main(String[] args) {
        GetAns demo = new GetAns();
        int idx = demo.getAns(new int[]{7,9,4,5});
        System.out.println(idx);
    }

    public int getAns(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int[] copyArr = Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        int len = a.length;
        int val = (len & 1) == 1 ? a[a.length >> 1] : a[(a.length >> 1) - 1];
        for (int i = 0; i < copyArr.length; i++) {
            if (val == copyArr[i]) {
                return i;
            }
        }
        return 0;
    }
}
