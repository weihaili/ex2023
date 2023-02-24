package nowcoder.ex20230224;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 18:10
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        RemoveNthFromEnd demo = new RemoveNthFromEnd();
        ListNode root = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        ListNode root1 = new ListNode(0);
        ListNode node = demo.removeNthFromEnd(root1, 1);
        System.out.println(node.val);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode root = head;
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int size = nodes.size();
        if (n == size) {
            root.next = null;
            if (size == 1) {
                return null;
            }
            return nodes.get(size - n + 1);
        } else if (n == 1) {
            nodes.get(size - n - 1).next = null;
            return root;
        } else {
            nodes.get(size - n  - 1).next = nodes.get(size - n + 1);
            return root;
        }
    }
}
