package leetcdoe.ex20230303;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/3 16:40
 */
public class CanVisitAllRooms {

    public static void main(String[] args) {
        CanVisitAllRooms demo = new CanVisitAllRooms();
        List<List<Integer>> rooms = new ArrayList<>();
        boolean flag = demo.canVisitAllRooms(rooms);
        System.out.println(flag);
    }

    boolean[] vis;

    int cnt;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        cnt = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return cnt == n;
    }

    private void dfs(List<List<Integer>> rooms, int i) {
        vis[i] = true;
        ++cnt;
        for (int k : rooms.get(i)) {
            if (!vis[k]) {
                dfs(rooms, k);
            }
        }
    }

    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        int n = rooms.size();
        int num = 0;
        boolean[] vis = new boolean[n];
        vis[0] = true;
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(0);
        while (!que.isEmpty()) {
            int idx = que.poll();
            ++num;
            for (int i : rooms.get(idx)){
                if (!vis[i]) {
                    vis[i] = true;
                    que.offer(i);
                }
            }
        }
        return num == n;
    }

    public boolean canVisitAllRooms0(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> noEnterMap = new HashMap<>();
        for (int i = 0; i < rooms.size(); ++i) {
            if (set.contains(i) || i == 0) {
                set.addAll(rooms.get(i));
            } else {
                noEnterMap.put(i, rooms.get(i));
            }
        }
        if (noEnterMap.size() > 0) {
            Iterator<Entry<Integer, List<Integer>>> iterator = noEnterMap.entrySet().iterator();

        }
        return false;
    }
}
