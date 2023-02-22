package leetcdoe.ex202302022;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 14:38
 */
public class FindWhetherExistsPath {

    public static void main(String[] args) {
        FindWhetherExistsPath demo = new FindWhetherExistsPath();
        int[][] graph = new int[][]{{0,1},{0,2},{1,2},{1, 2}};
        int start = 0;
        int target = 2;
        boolean flag = demo.findWhetherExistsPath(3, graph, start, target);
        System.out.println(flag);
    }

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[graph.length];

        return dfs(graph, start, target, visited);
    }
    
    private boolean dfs(int[][] graph, int start, int target, boolean[] visited) {
        for (int i = 0; i < graph.length; ++i) {
            if (!visited[i]) {
                if (graph[i][0] == start && graph[i][1] == target) {
                    return true;
                }
                visited[i] = true;
                if (graph[i][1] == target && dfs(graph, start, graph[i][0], visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    } 
}
