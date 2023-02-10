package leetcdoe.ex202302010.readwritelock;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 17:47
 */
public class FindKthBit {
    public static void main(String[] args) {
        FindKthBit demo = new FindKthBit();
        char ch = demo.findKthBit(5, 11);
        System.out.println(ch);
    }

    public char findKthBit(int n, int k) {
        if (k == 1) {
            return '0';
        }
        int mid = 1 << (n - 1);
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            k = (mid << 1) - k;
            return invert(findKthBit(n - 1, k));
        }

    }

    public char invert(char bit) {
        return (char)('0' + '1' - bit);
    }
}
