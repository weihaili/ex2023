package nowcoder.ex20230307;

import java.util.ArrayList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 14:07
 */
public class GetMedian {

    public static void main(String[] args) {
        GetMedian demo = new GetMedian();
        int [] arr = new int[]{1, 2, 3, 4};
        for (int num : arr) {
            demo.Insert(num);
        }
        Double res = demo.GetMedian();
        System.out.println(res);
    }

    private ArrayList<Integer> data = new ArrayList<>();

    public void Insert(Integer num) {
        if (data.isEmpty()) {
            data.add(num);
            return;
        }
        int i = 0;
        for (; i < data.size(); ++i) {
            if (num <= data.get(i)) {
                break;
            }
        }
        data.add(i, num);
    }

    public Double GetMedian() {
        int size = data.size();
        if ((size & 1) == 1) {
            return (double)data.get(size >> 1);
        } else {
            return ((double)data.get(size >> 1) + (double)data.get((size >> 1) - 1)) / 2;
        }
    }
}
