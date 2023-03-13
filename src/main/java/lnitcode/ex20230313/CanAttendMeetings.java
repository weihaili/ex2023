package lnitcode.ex20230313;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 10:27
 */
public class CanAttendMeetings {

    public static void main(String[] args) {
        CanAttendMeetings demo = new CanAttendMeetings();
        boolean flag = demo.canAttendMeetings(new ArrayList<>());
        System.out.println(flag);
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return true;
        }
        Collections.sort(intervals, (it1, it2) -> it1.start - it2.start);
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }
        return true;
    }
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
