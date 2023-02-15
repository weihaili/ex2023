package leetcdoe.ex202302015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 16:06
 */
public class GetRowYanghuiTringle {

    public static void main(String[] args) {
        GetRowYanghuiTringle demo = new GetRowYanghuiTringle();
        List<Integer> row = demo.getRow(3);
        System.out.println(Arrays.toString(row.toArray()));
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<>();
        }
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }

    public List<Integer> getRow1(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> yhist = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> list = new ArrayList();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(yhist.get(i - 1).get(j - 1) + yhist.get(i - 1).get(j));
                }
            }
            yhist.add(list);
        }
        return yhist.get(rowIndex);
    }
}
