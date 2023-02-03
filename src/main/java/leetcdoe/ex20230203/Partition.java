package leetcdoe.ex20230203;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/3 17:09
 */
public class Partition {

    public static void main(String[] args) {
        Partition demo = new Partition();
        ListNode head = new ListNode(0, new ListNode(3, new ListNode(2, new ListNode(6, new ListNode(1, new ListNode(11))))));
        ListNode newHead = demo.partition(head, 6);
        StringBuilder buf = new StringBuilder();
        while (newHead != null) {
            buf.append(" ").append(newHead.val);
            newHead = newHead.next;
        }
        System.out.println(buf.toString());
    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode sHead = small;
        ListNode large = new ListNode(0);
        ListNode lHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = lHead.next;
        return sHead.next;
    }
}
