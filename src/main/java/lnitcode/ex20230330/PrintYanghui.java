package lnitcode.ex20230330;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintYanghui {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            List<Integer> temp = new ArrayList<>(i + 1);
            if (i < 3) {
                for (int j = 0; j < i; j++) {
                    temp.add(1);
                }
                list.add(temp);
                continue;
            }
            for (int j = 0; j < i; ++j) {
                if (j == 0 || j == i - 1) {
                    temp.add(1);
                } else {
                    temp.add(list.get(i - 2).get(j - 1) + list.get(i - 2).get(j));
                }
            }
            list.add(temp);
        }
        StringBuilder buf = new StringBuilder();
        for (List<Integer> temp : list) {
            for (int num : temp) {
                buf.append(" ").append(num);
            }
            System.out.println(buf.substring(1));
            buf.delete(0, buf.length());
        }
    }
}
