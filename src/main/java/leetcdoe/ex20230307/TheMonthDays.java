package leetcdoe.ex20230307;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 17:07
 */
public class TheMonthDays {

    public static void main(String[] args) {
        TheMonthDays demo = new TheMonthDays();
        int days = demo.getTheMonthDays(2000, 3);
        System.out.println(days);
    }

    public int getTheMonthDays(int year, int month) {
        boolean leapFlag = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        boolean thirtyOneFlag = month == 1 || month == 3 || month == 5 || month == 7 ||
            month == 8 || month == 10 || month == 12;
        boolean thirtyFlag = month == 4 || month == 6 || month == 9 || month == 11;
        if (thirtyOneFlag) {
            return 31;
        }
        if (thirtyFlag) {
            return 30;
        }
        if (leapFlag) {
            return 29;
        } else {
            return 28;
        }
    }
}
