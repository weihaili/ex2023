package lnitcode.ex20230330;

import java.util.Scanner;

public class BouncedBall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double curH = 100f;
        double sumDistance = 100f;
        int pow = 2;
        while (pow <= n) {
            curH /= 2;
            sumDistance += curH * 2;
            ++pow;
        }
        System.out.println(String.format("%.2f", sumDistance));
    }
}
