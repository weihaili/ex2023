package leetcdoe.ex202302024;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 16:27
 */
public class InsertionSortList {

    public static void main(String[] args) {
        InsertionSortList demo = new InsertionSortList();

        ListNode root = new ListNode(4, new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(2)))));
        ListNode node = demo.insertionSortList(root);
        System.out.println(node.val);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lastSorted = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode pre = dummy;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }
}
