package lnitcode.ex20230313;

import com.google.common.base.Ascii;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 16:10
 */
public class FindHer {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        if (n >= 0 && n <= 127) {
            System.out.println((char)n);
        } else {
            System.out.println("error");
        }
    }


}
