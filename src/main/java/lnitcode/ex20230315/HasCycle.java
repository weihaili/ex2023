package lnitcode.ex20230315;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 15:19
 */
public class HasCycle {

    public static void main(String[] args) {
        HasCycle demo = new HasCycle();
        ListNode root = new ListNode(0);
        ListNode root1 = new ListNode(1);
        root.next = root1;
        ListNode root2 = new ListNode(2);
        root1.next = root2;
        //root2.next = root;
        boolean flag = demo.hasCycle(root);
        System.out.println(flag);
        ListNode node = demo.middleNode(root);
        System.out.println(node.val);
        ListNode lnode = demo.nthToLast(root, 4);
        System.out.println(lnode.val);
    }

    public ListNode nthToLast(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            while (n > 0) {
                if (fast == null) {
                    return null;
                }
                fast = fast.next;
                --n;
            }
            if (fast == null) {
                return slow;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
