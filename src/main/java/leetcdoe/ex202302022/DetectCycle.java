package leetcdoe.ex202302022;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 10:46
 */
public class DetectCycle {

    public static void main(String[] args) {
        DetectCycle demo = new DetectCycle();
        ListNode head = new ListNode(3);
        ListNode two = new ListNode(2);
        head.next = two;
        ListNode zero = new ListNode(0);
        two.next = zero;
        ListNode negFour = new ListNode(-4);
        zero.next = negFour;
        negFour.next = two;
        ListNode node = demo.detectCycle(head);
        System.out.println(node.val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode pivot = head;
                while (pivot != slow) {
                    pivot = pivot.next;
                    slow = slow.next;
                }
                return pivot;
            }
        }
        return null;
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

