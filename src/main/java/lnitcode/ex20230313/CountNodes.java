package lnitcode.ex20230313;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 13:47
 */
public class CountNodes {

    public static void main(String[] args) {
        CountNodes demo = new CountNodes();
        ListNode root = new ListNode(0);
        ListNode node1 = new ListNode(1);
        root.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        int count = demo.countNodes(root);
        System.out.println(count);
    }

    public int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }
}
