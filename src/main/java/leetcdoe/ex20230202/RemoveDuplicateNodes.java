package leetcdoe.ex20230202;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/2 17:31
 */
public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        RemoveDuplicateNodes demo = new RemoveDuplicateNodes();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2))));
        ListNode newHead = demo.removeDuplicateNodes(head);
        if (newHead == null) {
            System.out.println("newHead is null");
        }
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> rule = new HashSet<>();
        ListNode cur = head;
        rule.add(cur.val);
        while (cur.next != null) {
            if (rule.add(cur.next.val)) {
                cur = cur.next;
                continue;
            }
            cur.next = cur.next.next;
        }
        cur.next = null;
        return head;
    }
}

class ListNode {
    int val;

    ListNode next;

    ListNode(int x){
        val = x;
    }

    ListNode(int x, ListNode next){
        val = x;
        this.next = next;
    }
}
