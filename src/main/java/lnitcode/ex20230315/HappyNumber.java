package lnitcode.ex20230315;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 16:06
 */
public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber demo = new HappyNumber();
        boolean flag = demo.isHappy(10);
        System.out.println(flag);
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getFast(n);
        while (fast != 1 && slow != fast) {
            slow = fast;
            fast = getFast(fast);
        }
        return fast == 1;
    }

    private int getFast(int n) {
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum += num * num;
            n /= 10;
        }
        return sum;
    }
}
