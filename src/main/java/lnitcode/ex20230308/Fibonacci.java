package lnitcode.ex20230308;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 17:14
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci demo = new Fibonacci();
        int num = demo.fibonacci(10);
        System.out.println(num);
    }

    public int fibonacci(int n) {
        if (n < 1) {
            return 0;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                nums[i] = i;
            } else {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
        }
        return nums[n - 1];
    }
}
