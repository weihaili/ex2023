package nowcoder.ex20230224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 17:01
 */
public class MergeKLists {

    public static void main(String[] args) {
        MergeKLists demo = new MergeKLists();
        ListNode node1 = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode node2 = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(5, new ListNode(6, new ListNode(7)));
        ListNode root = demo.mergeKLists(new ArrayList<>(Arrays.asList(node1, node2, node3)));
        System.out.println(root.val);
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> que = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode root : lists) {
            while (root != null) {
                que.add(root);
                root = root.next;
            }
        }
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while (!que.isEmpty()) {
            ListNode temp = que.poll();
            head.next = temp;
            head = head.next;
        }
        head.next = null;
        return res.next;
    }
}
