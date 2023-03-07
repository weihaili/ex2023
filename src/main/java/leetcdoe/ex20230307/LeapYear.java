package leetcdoe.ex20230307;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 17:03
 */
public class LeapYear {

    public static void main(String[] args) {
        LeapYear demo = new LeapYear();
        boolean flag = demo.isLeapYear(2018);
        System.out.println(flag);
    }

    public boolean isLeapYear(int n) {
        return (n % 4 == 0 && n % 100 != 0) || n % 400 == 0;
    }
}
