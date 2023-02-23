package leetcdoe.ex202302023;

import org.springframework.cglib.core.Converter;
import org.springframework.context.ApplicationEvent;
import org.springframework.validation.ValidationUtils;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/23 9:26
 */
public class SpringLearn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = sc.nextInt();
        System.out.printf("%-15s%03d%n",str, num);
        System.out.println();
        System.out.printf("%03d%n", num);
    }
}
