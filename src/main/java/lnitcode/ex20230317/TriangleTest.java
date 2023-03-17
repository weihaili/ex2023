package lnitcode.ex20230317;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 17:52
 */
public class TriangleTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a + b;
        if (a <= 0 || b <= 0 || c >= 180) {
            System.out.println("无法组成三角形");
        }
        if (c < 90) {
            System.out.println("钝角三角形");
        } else if (c == 90) {
            System.out.println("直角三角形");
        } else {
            System.out.println("锐角三角形");
        }
    }
}
