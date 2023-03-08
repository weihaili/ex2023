package lnitcode.ex20230308;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 18:50
 */
public class MiddleNode {

    public static void main(String[] args) {
        MiddleNode demo = new MiddleNode();
        ListNode odd = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        ListNode even = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode node = demo.middleNode(even);
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("node is null");
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        return nodes.get(nodes.size() >> 1);
    }
}
