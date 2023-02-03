package leetcdoe.ex20230203;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/3 16:16
 */
public class KthToLast {

    public static void main(String[] args) {
        KthToLast demo = new KthToLast();
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        int res = demo.kthToLast(head, 1);
        System.out.println(res);
    }

    public int kthToLast(ListNode head, int k) {
        ListNode lN = head;
        ListNode rN = head;
        while (rN != null) {
            rN = rN.next;
            if (k > 0) {
                --k;
            } else {
                lN = lN.next;
            }
        }
        return lN.val;
    }

    public int kthToLast3(ListNode head, int k) {
        int res = 0;
        if (head == null || k <= 0) {
            return res;
        }
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        int size = values.size();
        if (k > size) {
            return res;
        }
        return values.get(size - k);
    }

    public int kthToLast1(ListNode head, int k) {
        int res = 0;
        if (head == null || k <= 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        if (stack.size() < k) {
            return res;
        }
        while (k > 0) {
            res = stack.pop();
            --k;
        }
        return res;
    }
}

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
