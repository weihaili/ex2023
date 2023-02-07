package leetcdoe.ex20230207;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/7 16:30
 */
public class RemoveElements {
    public static void main(String[] args) {
        RemoveElements demo = new RemoveElements();
        ListNode head = new ListNode(3, new ListNode(3, new ListNode(1)));
        ListNode newHead = demo.removeElements(head, 3);
        System.out.println(newHead.val);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }


    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode newRoot = null;
        boolean existNewRootFlag = false;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val == val) {
                if (pre != null) {
                    pre.next = next;
                } else {
                    cur.next = null;
                }
            } else {
                if (!existNewRootFlag) {
                    newRoot = cur;
                    existNewRootFlag = true;
                }
                pre = cur;
            }
            cur = next;
        }
        return newRoot;
    }
}
