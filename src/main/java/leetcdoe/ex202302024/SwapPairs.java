package leetcdoe.ex202302024;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 10:54
 */
public class SwapPairs {

    public static void main(String[] args) {
        SwapPairs demo = new SwapPairs();
        ListNode node = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode root = demo.swapPairs(node);
        System.out.println(root.val);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = head.next;
        head.next = swapPairs(root.next);
        root.next = head;
        return root;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
