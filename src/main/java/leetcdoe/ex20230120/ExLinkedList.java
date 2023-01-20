package leetcdoe.ex20230120;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ExLinkedList {

    public static void main(String[] args) {
        ExLinkedList demo = new ExLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        /*int[] res = demo.reversePrint(head);
        System.out.println(Arrays.toString(res));*/

        ListNode root = demo.reverseList(head);
        if (root == null) {
            System.out.println("root is null");
        } else {
            System.out.println(root.val);
        }
    }

    public ListNode reverseList4(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            stack.push(temp);
            head = head.next;
        }
        ListNode root = stack.pop();
        ListNode cur = root;
        while (!stack.isEmpty()) {
            ListNode next = stack.pop();
            cur.next = next;
            cur = next;
        }
        return root;
    }

    public ListNode reverseList2(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        while (head != null) {
            deque.push(head);
            head = head.next;
        }
        return deque.peekLast();
    }

    public ListNode reverseList3(ListNode head) {
        ListNode res = head;
        while (head != null) {
            if (head.next == null) {
                return head;
            }
            head = head.next;
        }
        return res;
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        int size = values.size();
        int[] res = new int[size];
        for (int i = values.size() - 1; i > -1 ; --i) {
            res[size - i -1] = values.get(i);
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
