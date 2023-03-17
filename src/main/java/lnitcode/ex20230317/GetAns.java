package lnitcode.ex20230317;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 11:20
 */
public class GetAns {

    public static void main(String[] args) {
        GetAns demo = new GetAns();
        List<Interval> a = Arrays.asList(
            new Interval(27, 74), new Interval(25, 65), new Interval(8, 36),
            new Interval(21, 63), new Interval(18, 20), new Interval(35, 51),
            new Interval(55, 86), new Interval(49, 69), new Interval(79, 89));
        int cnt = demo.getAns(Arrays.asList(new Interval(1,5), new Interval(4,8), new Interval(10, 12)));
        System.out.println(cnt);
    }

    public int getAns(List<Interval> a) {
        if (a == null || a.size() == 0) {
            return 0;
        }
        /*Collections.sort(a, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end == o2.end ? o2.end - o1.end : o1.end - o2.end;
            }
        });*/
        Collections.sort(a, (o1, o2) -> o1.end == o2.end ? o2.end - o1.end : o1.end - o2.end);
        int cnt = 0;
        int sv = -1;
        for (int i = 0; i < a.size(); ++i) {
            if (a.get(i).start > sv) {
                sv = a.get(i).end;
                ++cnt;
            }
        }
        return cnt;
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
