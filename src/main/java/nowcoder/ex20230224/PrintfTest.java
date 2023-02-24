package nowcoder.ex20230224;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 8:48
 */
public class PrintfTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= 10; ++i) {
            System.out.printf("%d x %d = %d\n", n, i, n*i);
        }
        sc.close();
    }
}
