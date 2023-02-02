package leetcdoe.ex20230202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/2 11:25
 */
public class GenerateYangHuiTriangle {

    public static void main(String[] args) {
        GenerateYangHuiTriangle demo = new GenerateYangHuiTriangle();
        int rows = 2;
        List<List<Integer>> list = demo.generate(rows);
        if (list == null) {
            System.out.println("list is null");
            return;
        }
        StringBuilder buf = new StringBuilder();
        for (List<Integer> integers : list) {
            if (buf.length() > 0) {
                buf.delete(0, buf.length());
            }
            integers.forEach(ele -> buf.append(" ").append(ele));
            System.out.println(buf.substring(1));
        }

        System.out.println("**********************************");
        for(int i = 0; i < rows; ++i) {
            for (int k = 1; k < rows - i; ++k) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; ++j) {
                System.out.print(list.get(i).get(j));
                if (j != i) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
