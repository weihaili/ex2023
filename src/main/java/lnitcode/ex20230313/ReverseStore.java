package lnitcode.ex20230313;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 11:40
 */
public class ReverseStore {

    public static void main(String[] args) {
        ReverseStore demo = new ReverseStore();
        ListNode root = new ListNode(0);
        ListNode node = new ListNode(1);
        root.next = node;
        List<Integer> res = demo.reverseStore(root);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> reverseStore(ListNode head) {
        if (head == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
