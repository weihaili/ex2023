package leetcdoe.ex20230303;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/3 16:22
 */
public class FindSmallestSetOfVertices {

    public static void main(String[] args) {
        FindSmallestSetOfVertices demo = new FindSmallestSetOfVertices();
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> res = demo.findSmallestSetOfVertices(6, edges);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> nums = new HashSet<>();
        for (List<Integer> edge : edges) {
            nums.add(edge.get(1));
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (!nums.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
