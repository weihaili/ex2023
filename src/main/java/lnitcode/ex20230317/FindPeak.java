package lnitcode.ex20230317;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 14:59
 */
public class FindPeak {

    public static void main(String[] args) {
        FindPeak demo = new FindPeak();
        int idx = demo.findPeak(new int[]{1, 2, 1});
        System.out.println(idx);
    }

    public int findPeak(int[] a) {
        if (a == null || a.length < 3) {
            return -1;
        }
        for (int i = 1; i < a.length - 1; ++i) {
            if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
