package lnitcode.ex20230313;

public enum WeekDay {
    SUN("Restday"), MON("Workday"), TUE("Workday"), WED("Workday"),
    THU("Workday"), FRI("Workday"), SAT("Restday");
    private final String day;

    // write your code here
    WeekDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public static WeekDay[] getWorkDay() {
        WeekDay[] workDays = {WeekDay.MON, WeekDay.TUE, WeekDay.WED, WeekDay.THU, WeekDay.FRI};
        return workDays;
    }
    public static WeekDay[] getRestDay() {
        WeekDay[] restDays = {WeekDay.SUN, WeekDay.SAT};
        return restDays;
    }
}
