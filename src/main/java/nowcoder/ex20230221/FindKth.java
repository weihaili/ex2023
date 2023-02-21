package nowcoder.ex20230221;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 18:26
 */
public class FindKth {

    public static void main(String[] args) {
        FindKth demo = new FindKth();
        int val = demo.findKth(new int[]{10,10,9,9,8,7,5,6,4,3,4,2}, 12, 3);
        System.out.println(val);
    }

    public int findKth(int[] a, int n, int K) {
        Queue<Integer> que = new PriorityQueue<>(K);
        for (int num : a) {
            if (que.size() < K) {
                que.add(num);
            } else {
                if (que.peek() < num) {
                    que.poll();
                    que.add(num);
                }
            }
        }
        return que.isEmpty() ? 0 : que.peek();
    }
}
