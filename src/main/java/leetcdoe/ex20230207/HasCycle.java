package leetcdoe.ex20230207;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/7 15:33
 */
public class HasCycle {

    public static void main(String[] args) {
        HasCycle demo = new HasCycle();
        ListNode node = new ListNode(3);
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, node)));
        node.next = head;
        boolean flag = demo.hasCycle(head);
        System.out.println(flag);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> nodes = new HashSet<>();
        while (head !=null) {
            if (!nodes.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
