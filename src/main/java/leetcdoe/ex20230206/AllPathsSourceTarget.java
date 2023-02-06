package leetcdoe.ex20230206;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/6 16:31
 */
public class AllPathsSourceTarget {
    public static void main(String[] args) {
        AllPathsSourceTarget demo = new AllPathsSourceTarget();
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> res = demo.allPathsSourceTarget(graph);
        if (res == null) {
            System.out.println("res is null");
        }
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> stack = new ArrayDeque<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return res;
    }

    private void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int num : graph[x]) {
            stack.offerLast(num);
            dfs(graph, num, n);
            stack.pollLast();
        }
    }
}
