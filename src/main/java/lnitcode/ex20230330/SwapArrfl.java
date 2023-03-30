package lnitcode.ex20230330;

import java.util.Arrays;
import java.util.Scanner;

public class SwapArrfl {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String numStr = sc.nextLine();
        String[] numStrs = numStr.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.valueOf(numStrs[i]);
        }
        int temp = nums[0];
        nums[0] = nums[n - 1];
        nums[n - 1] = temp;
        StringBuilder buf = new StringBuilder();
        for (int num : nums) {
            buf.append(" ").append(num);
        }
        System.out.println(buf.substring(1));
    }
}
