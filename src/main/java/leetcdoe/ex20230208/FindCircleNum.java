package leetcdoe.ex20230208;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/8 16:43
 */
public class FindCircleNum {

    public static void main(String[] args) {
        FindCircleNum demo = new FindCircleNum();
        int[][] nums = {{1,1,0},{1,1,0},{0,0,1}};
        int cnt = demo.findCircleNum(nums);
        System.out.println(cnt);
    }

    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        if (isConnected == null || isConnected.length == 0) {
            return provinces;
        }
        int cities = isConnected.length;
        int[] parent = new int[cities];
        for (int i = 0; i < cities; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < cities; ++i) {
            for (int j = i + 1; j < cities; ++j) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        for (int i = 0; i < cities; ++i) {
            if (parent[i] == i) {
                ++provinces;
            }
        }
        return provinces;
    }

    private void union(int[] parent, int idx1, int idx2) {
        parent[find(parent, idx1)] = find(parent, idx2);
    }

    private int find(int[] parnet, int idx) {
        if (parnet[idx] != idx) {
            parnet[idx] = find(parnet, parnet[idx]);
        }
        return parnet[idx];
    }

    public int findCircleNumByBfs(int[][] isConnected) {
        int provinces = 0;
        if (isConnected == null || isConnected.length == 0) {
            return provinces;
        }
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < cities; ++i) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < cities; ++k) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                ++provinces;
            }
        }
        return provinces;
    }

    public int findCircleNumByDfs(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; ++i) {
            if (!visited[i]) {
                dfs(isConnected, visited, cities, i);
                ++provinces;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; ++j) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, cities, j);
            }
        }
    }
}
