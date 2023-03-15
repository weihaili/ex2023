package lnitcode.ex20230315;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 19:06
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MergeTwoLists demo = new MergeTwoLists();
        ListNode node = demo.mergeTwoLists(new ListNode(0, new ListNode(1, new ListNode(2))), new ListNode(2, new ListNode(3, new ListNode(4))));
        StringBuilder buf = new StringBuilder();
        while (node != null) {
            buf.append(node.val);
            node = node.next;
        }
        System.out.println(buf.toString());
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int n2 = l2 == null ? Integer.MAX_VALUE :  l2.val;
            if (n1 <= n2) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
