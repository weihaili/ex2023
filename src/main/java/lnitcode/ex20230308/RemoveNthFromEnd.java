package lnitcode.ex20230308;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 17:45
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        RemoveNthFromEnd demo = new RemoveNthFromEnd();
        ListNode root = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        ListNode node = demo.removeNthFromEnd(new ListNode(0), 1);
        if (node == null) {
            System.out.println("node is null");
        } else {
            StringBuilder buf = new StringBuilder();
            while (node != null) {
                buf.append("->").append(node.val);
                node = node.next;
            }
            System.out.println(buf.substring(2));
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        List<ListNode> data = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            data.add(temp);
            temp = temp.next;
        }
        int size = data.size();
        if (n > size) {
            return null;
        } else if (size == n) {
            ListNode node = data.get(0);
            node.next = null;
            return size == 1 ? null : data.get(1);
        } else {
            if (n == 1) {
                ListNode node = data.get(size - 2);
                node.next = null;
                return head;
            } else {
                ListNode pre = data.get(size - 1 - n);
                ListNode pos = data.get(size - n + 1);
                pre.next = pos;
                return head;
            }
        }
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
