package nowcoder.ex20230307;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 15:32
 */
public class PermuteUnique {

    public static void main(String[] args) {
        PermuteUnique demo = new PermuteUnique();
        ArrayList<ArrayList<Integer>> res = demo.permuteUnique(new int[]{0,1});
        for (ArrayList<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        int len = num.length;
        boolean[] visited = new boolean[len];
        recursion(res, num, new ArrayList<Integer>(), visited);
        return res;
    }

    private void recursion(ArrayList<ArrayList<Integer>> res, int[] num, ArrayList<Integer> temp, boolean[] visited) {
        if (temp.size() == num.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && num[i - 1] == num[i] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            temp.add(num[i]);
            recursion(res, num, temp, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
