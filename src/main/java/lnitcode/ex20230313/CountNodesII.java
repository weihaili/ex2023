package lnitcode.ex20230313;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 14:10
 */
public class CountNodesII {

    public static void main(String[] args) {
        CountNodesII demo = new CountNodesII();
        ListNode node = new ListNode(-3);
        ListNode node1 = new ListNode(-1);
        node.next = node1;
        ListNode node2 = new ListNode(0);
        node1.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        ListNode node4 = new ListNode(3);
        node3.next = node4;
        int cnt = demo.countNodesII(node);
        System.out.println(cnt);
    }

    public int countNodesII(ListNode head) {
        int cnt = 0;
        while (head != null) {
            int val = head.val;
            if (val > 0 && (val & 1) == 1) {
                ++cnt;
            }
            head = head.next;
        }
        return cnt;
    }
}
