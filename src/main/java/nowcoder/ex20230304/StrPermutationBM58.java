package nowcoder.ex20230304;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 19:22
 */
public class StrPermutationBM58 {

    public static void main(String[] args) {
        StrPermutationBM58 demo = new StrPermutationBM58();
        ArrayList<String> res = demo.Permutation("ab");
        System.out.println(Arrays.toString(res.toArray()));
    }

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[str.length()];
        Arrays.fill(visited, false);
        StringBuilder buf = new StringBuilder();
        ArrayList<String> res = new ArrayList<>();
        recursion(res, chars, buf, visited);
        return res;
    }

    private void recursion(ArrayList<String> res, char[] chars, StringBuilder buf, boolean[] visited) {
        if (buf.length() == chars.length) {
            res.add(buf.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && chars[i -1] == chars[i] && !visited[i -1]) {
                continue;
            }
            visited[i] = true;
            buf.append(chars[i]);
            recursion(res, chars, buf, visited);
            visited[i] = false;
            buf.deleteCharAt(buf.length() - 1);
        }
    }
}
