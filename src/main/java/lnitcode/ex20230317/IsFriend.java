package lnitcode.ex20230317;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 17:22
 */
public class IsFriend {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(isFriend(n));
        }
    }

    public static boolean isFriend(int n) {
        return Integer.bitCount(n) == 2;
    }
}
