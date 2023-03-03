package leetcdoe.ex20230303;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/3 18:20
 */
public class HIndex {

    public static void main(String[] args) {
        HIndex demo = new HIndex();
        int num = demo.hIndex(new int[]{3,0,6,1,5});
        System.out.println(num);
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hx = 0;
        int len = citations.length - 1;
        while (len >= 0 && citations[len] > hx) {
            ++hx;
            --len;
        }
        return hx;
    }
}
