package lnitcode.ex20230315;

import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 18:25
 */
public class Reverse {

    public static void main(String[] args) {
        Reverse demo = new Reverse();
        ListNode node = demo.reverse(new ListNode(0, new ListNode(1, new ListNode(2))));
        StringBuilder buf = new StringBuilder();
        while (node != null) {
            buf.append(node.val);
            node = node.next;
        }
        System.out.println(buf.toString());
    }

    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode cur = head;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
}
