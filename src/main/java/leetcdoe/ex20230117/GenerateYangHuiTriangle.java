package leetcdoe.ex20230117;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;

public class GenerateYangHuiTriangle {

    public static void main(String[] args) {
        GenerateYangHuiTriangle demo = new GenerateYangHuiTriangle();
        int rows = 5;
        List<List<Integer>> res = demo.generate(rows);
        StringBuilder buf = new StringBuilder();
        for (List<Integer> re : res) {
            if (buf.length() > 0) {
                buf.delete(0, buf.length());
            }
            for (int num : re) {
                buf.append(" ").append(num);
            }
            System.out.println(buf.substring(1));
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j ==i) {
                    row.add(1);
                } else {
                    row.add(res.get(i -1).get(j - 1) + res.get(i -1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
