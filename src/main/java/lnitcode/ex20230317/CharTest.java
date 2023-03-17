package lnitcode.ex20230317;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 17:02
 */
public class CharTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n < 0 || n > 127) {
                System.out.println("error");
            }
            System.out.println((char)n);
        }
    }
}
