package nowcoder.ex20230224;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 17:42
 */
public class EntryNodeOfLoop {

    public static void main(String[] args) {
        EntryNodeOfLoop demo = new EntryNodeOfLoop();
        ListNode root = new ListNode(0);
        ListNode node1 = new ListNode(1);
        root.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        node3.next = node2;
        ListNode node = demo.EntryNodeOfLoop(root);
        System.out.println(node.val);
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = hasCycle(pHead);
        if (slow == null) {
            return null;
        }
        ListNode fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode hasCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
