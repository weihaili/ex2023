package leetcdoe.ex202302021;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 13:31
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        GetIntersectionNode demo = new GetIntersectionNode();
        ListNode headA = new ListNode(3);
        ListNode nodeA1 = new ListNode(4);
        headA.next = nodeA1;
        ListNode nodeA2 = new ListNode(5);
        nodeA1.next = nodeA2;

        ListNode headB = new ListNode(4);
        ListNode nodeB1 = new ListNode(5);
        headB.next = nodeB1;
        ListNode node = demo.getIntersectionNode(headA, headB);
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("node is null");
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
