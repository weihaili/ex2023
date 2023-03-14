package lnitcode.ex20230314;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 19:12
 */
public class Prime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n = 2;
        while (n <= num) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(n); ++i) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(n);
            }
            ++n;
        }
    }
}
