package nowcoder.ex20230224;

import java.util.PriorityQueue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 16:42
 */
public class Merge {

    public static void main(String[] args) {
        Merge demo = new Merge();
        ListNode root1 = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode root2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode node = demo.Merge(root1, root2);
        System.out.println(node);
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        PriorityQueue<ListNode> pqu = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);
        while (list1 != null) {
            pqu.offer(list1);
            list1 = list1.next;
        }
        while (list2 != null) {
            pqu.offer(list2);
            list2 = list2.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = pqu.poll();
        dummy.next = cur;
        while (!pqu.isEmpty()) {
            cur.next = pqu.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
