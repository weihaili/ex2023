package leetcdoe.ex202302023;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/23 13:46
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        GetIntersectionNode demo = new GetIntersectionNode();
        ListNode rootA = null;
        ListNode rootB = null;
        ListNode intersectionNodeFirst = demo.getIntersectionNode(rootA, rootB);
        System.out.println(intersectionNodeFirst.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!nodes.add(headB)) {
                return headB;
            }
            headB = headA.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
