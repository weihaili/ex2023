package lnitcode.ex20230330;

import java.util.Scanner;

public class OddEvenSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int oddSum = 0;
        int evenSum = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                oddSum += n;
            } else {
                evenSum += n;
            }
            --n;
        }
        System.out.println(oddSum);
        System.out.println(evenSum);
    }
}
