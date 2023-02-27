package leetcdoe.ex202302027;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 18:28
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ReverseKGroup demo = new ReverseKGroup();
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3,
            new ListNode(4, new ListNode(5))))));
        ListNode root = demo.reverseKGroup(head, 2);
        System.out.println(root.val);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode temp = head;
        while (pre != tail) {
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return new ListNode[]{tail, head};
    }
}
