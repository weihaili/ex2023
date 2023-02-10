package leetcdoe.ex202302010.readwritelock;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 18:02
 */
public class Candy {
    public static void main(String[] args) {
        Candy demo = new Candy();
        int cnt = demo.candy(new int[]{1, 2, 2});
        System.out.println(cnt);
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int len = ratings.length;
        int res = 1;
        int inc = 1;
        int dec = 0;
        int pre = 1;
        for (int i = 1; i < len; ++i) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                res += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                res += dec;
                pre = 1;
            }
        }
        return res;
    }
}
