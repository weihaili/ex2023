package lnitcode.ex20230313;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 11:46
 */
public class InsertNode {

    public static void main(String[] args) {
        InsertNode demo = new InsertNode();
        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(4);
        root.next = root1;
        ListNode root2 = new ListNode(6);
        root1.next = root2;
        ListNode root3 = new ListNode(8);
        root2.next = root3;
        // ListNode newRoot = demo.insertNode(root, 9);
        ListNode newRoot = demo.insertNode(new ListNode(1), 0);
        System.out.println(newRoot.val);
    }

    public ListNode insertNode(ListNode head, int val) {
        if (head == null) {
            return new ListNode(val);
        }
        ListNode node = new ListNode(val);
        if (head.val >= val) {
            node.next = head;
            return node;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if ((cur.val < val && next != null && next.val >= val) || next == null) {
                cur.next = node;
                node.next = next;
                break;
            } else {
                pre = cur;
                cur = next;
            }
        }
        return dummy.next;
    }
}
