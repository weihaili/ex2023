package leetcdoe.ex202302024;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 11:38
 */
public class MergeKLists {

    public static void main(String[] args) {
        MergeKLists demo = new MergeKLists();
        ListNode[] nodes = {new ListNode(0, new ListNode(1, new ListNode(2))), new ListNode(3, new ListNode(4, new ListNode(5))), null};
        ListNode root = demo.mergeKLists(nodes);
        System.out.println(root);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> que = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            while (node != null) {
                que.offer(node);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!que.isEmpty()) {
            cur.next = que.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
