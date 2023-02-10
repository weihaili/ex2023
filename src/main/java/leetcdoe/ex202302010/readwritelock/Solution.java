package leetcdoe.ex202302010.readwritelock;

import java.util.Random;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 17:23
 */
public class Solution {

    public static void main(String[] args) {
        Solution demo = new Solution(new ListNode(1, new ListNode(2)));
        for (int i = 0; i < 100; ++i) {
            int val = demo.getRandom();
            System.out.println(val);
        }
    }

    private Random random = null;
    ListNode head = null;

    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int i = 1;
        int res = 0;
        for (ListNode node = head; node != null; node = node.next) {
            if (random.nextInt(i) == 0) {
                res = node.val;
            }
            ++i;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
