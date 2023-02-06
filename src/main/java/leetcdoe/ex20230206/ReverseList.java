package leetcdoe.ex20230206;

import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/6 13:36
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(1, new ListNode(3))));
        ReverseList demo = new ReverseList();
        demo.print(head);
        System.out.println("************************************************");
        ListNode newHead = demo.reverseList(head);
        demo.print(newHead);

        System.out.println("************************************************");
        ListNode dHead = demo.deleteDuplicates(newHead);
        demo.print(dHead);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = next;
            }
        }
        return head;
    }

    private void print(ListNode head) {
        StringBuilder buf = new StringBuilder();
        while (head != null) {
            buf.append("->").append(head.val);
            head = head.next;
        }
        if (buf.length() > 0) {
            System.out.println(buf.substring(2));
        }
    }

    public ListNode reverseList(ListNode head) {
        while (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
