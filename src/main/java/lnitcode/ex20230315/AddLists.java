package lnitcode.ex20230315;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 18:34
 */
public class AddLists {

    public static void main(String[] args) {
        AddLists demo = new AddLists();
        ListNode node = demo.addLists(new ListNode(7, new ListNode(1, new ListNode(6))), new ListNode(5, new ListNode(9, new ListNode(2))));
        StringBuilder buf = new StringBuilder();
        while (node != null) {
            buf.append(node.val);
            node = node.next;
        }
        System.out.println(buf.toString());
    }

    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addLists1(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        StringBuilder buf = new StringBuilder();
        while (l1 != null) {
            buf.append(l1.val);
            l1 = l1.next;
        }
        long n1 = Long.parseLong(buf.reverse().toString());
        buf.delete(0, buf.length());
        while (l2 != null) {
            buf.append(l2.val);
            l2 = l2.next;
        }
        long sum = n1 + Long.parseLong(buf.reverse().toString());
        buf.delete(0, buf.length());
        buf.append(sum);
        buf.reverse();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < buf.length(); ++i) {
            ListNode node = new ListNode(buf.charAt(i) - 48);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
