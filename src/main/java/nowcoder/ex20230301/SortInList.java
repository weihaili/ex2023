package nowcoder.ex20230301;

import java.util.PriorityQueue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/1 19:00
 */
public class SortInList {

    public static void main(String[] args) {
        SortInList demo = new SortInList();
        ListNode head = new ListNode();
        head.val = 2;
        ListNode foot = new ListNode();
        foot.val = 0;
        head.next = foot;
        ListNode node = demo.sortInList(head);
        System.out.println(node.val);
    }

    public ListNode sortInList (ListNode head) {
        if (head == null) {
            return null;
        }
        PriorityQueue<ListNode> que = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        while (head != null) {
            que.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!que.isEmpty()) {
            cur.next = que.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}

class ListNode {
  int val;
  ListNode next = null;
}
