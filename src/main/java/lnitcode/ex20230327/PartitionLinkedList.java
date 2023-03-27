package lnitcode.ex20230327;

import java.util.ArrayList;
import java.util.List;

public class PartitionLinkedList {

    public static void main(String[] args) {
        PartitionLinkedList demo = new PartitionLinkedList();
        ListNode root = new ListNode(0, new ListNode(7, new ListNode(2, new ListNode(5, new ListNode(8)))));
        ListNode head = demo.partition(root, 3);
        StringBuilder buf = new StringBuilder();
        while (head != null) {
            buf.append(",").append(head.val);
            head = head.next;
        }
        System.out.println(buf.substring(1));
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        List<ListNode> smList = new ArrayList<>();
        List<ListNode> grOrEqList = new ArrayList<>();
        while (head != null) {
            int val = head.val;
            if (val < x) {
                smList.add(head);
            } else {
                grOrEqList.add(head);
            }
            head = head.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        if (!smList.isEmpty()) {
            for (ListNode node : smList) {
                cur.next = node;
                cur = cur.next;
            }
        }
        if (!grOrEqList.isEmpty()) {
            for (ListNode node : grOrEqList) {
                cur.next = node;
                cur = cur.next;
            }
        }
        cur.next = null;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
