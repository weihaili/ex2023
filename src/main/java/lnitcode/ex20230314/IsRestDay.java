package lnitcode.ex20230314;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 16:46
 */
public class IsRestDay {

    public static void main(String[] args) {
        boolean flag = isRestDay(WeekDay.SUN);
        System.out.println(flag);
    }

    public static boolean isRestDay(WeekDay day) {
        // write your code here
        return WeekDay.SUN.equals(day) || WeekDay.SAT.equals(day);
    }
}
