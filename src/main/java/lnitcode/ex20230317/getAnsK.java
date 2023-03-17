package lnitcode.ex20230317;

import java.util.PriorityQueue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 14:36
 */
public class getAnsK {

    public static void main(String[] args) {
        getAnsK demo = new getAnsK();
        long res = demo.getAns(new int[]{1, 3, 2, 5});
        System.out.println(res);
    }

    public long getAns(int[] atk) {
        long res = 0;
        if (atk == null || atk.length == 0) {
            return res;
        }
        PriorityQueue<Integer> que = new PriorityQueue<>((n1, n2) -> n2 - n1);
        long temp = 0;
        for (int num : atk) {
            que.offer(num);
            temp += num;
        }
        while (que.size() > 1) {
            temp -= que.poll();
            res += temp;
        }
        return res;
    }
}
