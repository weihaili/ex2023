package lnitcode.ex20230314;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 15:32
 */
public class GetRestDays {

    public static void main(String[] args) {
        List<WeekDay> list = Arrays.asList(WeekDay.WED, WeekDay.SUN , WeekDay.WED);
        EnumMap<WeekDay, Integer> map = getRestDays(list);
        for (Entry<WeekDay, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static EnumMap<WeekDay, Integer> getRestDays(List<WeekDay> list) {
        EnumMap<WeekDay, Integer> map = new EnumMap<WeekDay, Integer>(WeekDay.class);
        if (list == null || list.size() == 0) {
            return map;
        }
        for (WeekDay day : list) {
            if (WeekDay.SUN.equals(day) || WeekDay.SAT.equals(day)) {
                map.put(day, map.getOrDefault(day, 0) + 1);
            }
        }
        return map;
    }
}

enum WeekDay {
    SUN, MON, TUE, WED, THU, FRI, SAT;

}
