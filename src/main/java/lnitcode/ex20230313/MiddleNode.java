package lnitcode.ex20230313;

import java.util.ArrayList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 13:53
 */
public class MiddleNode {

    public static void main(String[] args) {
        MiddleNode demo = new MiddleNode();
        ListNode root = new ListNode(0);
        ListNode node1 = new ListNode(1);
        root.next = node1;
        ListNode root2 = new ListNode(2);
        node1.next = root2;
        ListNode root3 = new ListNode(3);
        root2.next = root3;
        ListNode node = demo.middleNode(root);
        System.out.println(node.val);

        int val = demo.getVal(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(val);
    }

    private int getVal(int[] ints) {
        int len = ints.length;
        return (len & 1) == 1 ? ints[len >> 1] : ints[(len >> 1) - 1];
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ArrayList<ListNode> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head);
            head = head.next;
        }
        int len = vals.size();
        return (len & 1) == 1 ? vals.get(len >> 1) : vals.get((len >> 1) - 1);
    }
}
