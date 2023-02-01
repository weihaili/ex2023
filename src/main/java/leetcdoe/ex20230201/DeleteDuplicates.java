package leetcdoe.ex20230201;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/1 11:23
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        DeleteDuplicates demo = new DeleteDuplicates();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4))))));
        ListNode header = demo.deleteDuplicates(head);
        while (header != null) {
            System.out.println(header.val);
            header = header.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
            } else {
                int repeatVal = cur.next.val;
                while (cur.next != null && cur.next.val == repeatVal) {
                    cur.next = cur.next.next;
                }
            }
        }
        return dummy.next;
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

    ;
}
