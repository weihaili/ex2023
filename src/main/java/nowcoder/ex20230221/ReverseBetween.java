package nowcoder.ex20230221;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 17:26
 */
public class ReverseBetween {

    public static void main(String[] args) {
        ReverseBetween demo = new ReverseBetween();
        ListNode head = new ListNode();
        head.val = 0;

        ListNode one = new ListNode();
        one.val = 1;
        head.next = one;

        ListNode two = new ListNode();
        two.val = 2;
        one.next = two;

        ListNode three = new ListNode();
        three.val = 3;
        two.next = three;

        ListNode newHead = demo.reverseBetween(head, 2, 4);
        if (newHead == null) {
            System.out.println("newHead is null");
            return;
        }
        System.out.println(newHead.val);
    }

    public ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; ++i) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode curNext;
        for (int i = 0; i < n - m; ++i) {
            curNext = cur.next;
            cur.next = curNext.next;
            curNext.next = pre.next;
            pre.next = curNext;
        }
        return dummy.next;
    }
}


class ListNode {
  int val;
  ListNode next = null;
}

