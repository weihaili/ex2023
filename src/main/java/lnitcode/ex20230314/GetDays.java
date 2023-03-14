package lnitcode.ex20230314;

import java.util.EnumMap;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 16:40
 */
public class GetDays {

    public static EnumMap<WeekDay, String> getDays() {
        EnumMap<WeekDay, String> map = new EnumMap<WeekDay, String>(WeekDay.class);
        map.put(WeekDay.SUN, "rest");
        map.put(WeekDay.MON, "work");
        map.put(WeekDay.TUE, "work");
        map.put(WeekDay.WED, "work");
        map.put(WeekDay.THU, "work");
        map.put(WeekDay.FRI, "work");
        map.put(WeekDay.SAT, "rest");
        return map;
    }
}
