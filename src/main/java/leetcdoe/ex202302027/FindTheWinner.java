package leetcdoe.ex202302027;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 17:27
 */
public class FindTheWinner {

    public static void main(String[] args) {
        FindTheWinner demo = new FindTheWinner();
        int order = demo.findTheWinner1(5, 2);
        System.out.println(order);
    }

    public int findTheWinner2(int n, int k) {
        int winner = 1;
        for (int i = 2; i <= n; ++i) {
            winner = (k + winner - 1) % i + 1;
        }
        return winner;
    }

    public int findTheWinner1(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (k + findTheWinner1(n - 1, k) - 1) % n + 1;
    }

    public int findTheWinner(int n, int k) {
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; ++i) {
            que.offer(i);
        }
        while (que.size() > 1) {
            for (int i = 1; i < k; ++i) {
                que.offer(que.poll());
            }
            que.poll();
        }
        return que.peek();
    }
}
