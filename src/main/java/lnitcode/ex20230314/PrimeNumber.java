package lnitcode.ex20230314;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 17:58
 */
public class PrimeNumber {

    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        if (num <= 1) {
            System.out.println(num + " is not a prime number");
            return;
        }
        boolean primeFlag = true;
        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                primeFlag = false;
                break;
            }
        }
        System.out.println(num + (primeFlag ? " is a prime number" : " is not a prime number"));
    }
}
