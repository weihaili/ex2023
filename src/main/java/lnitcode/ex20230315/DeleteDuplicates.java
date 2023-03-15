package lnitcode.ex20230315;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 18:11
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        DeleteDuplicates demo = new DeleteDuplicates();
        ListNode node = demo.deleteDuplicates(new ListNode(1));
        StringBuilder buf = new StringBuilder();
        while (node != null) {
            buf.append(node.val);
            node = node.next;
        }
        System.out.println(buf.toString());
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == next.val) {
                pre.next = next;
                cur = next;
            } else {
                pre = cur;
                cur = next;
            }
        }
        return dummy.next;
    }
}
