package lnitcode.ex20230315;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 18:04
 */
public class MultiplyLists {

    public static void main(String[] args) {
        MultiplyLists demo = new MultiplyLists();
        long l = demo.multiplyLists(new ListNode(9, new ListNode(4, new ListNode(6))), new ListNode(8, new ListNode(4)));
        System.out.println(l);
    }

    public long multiplyLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return 0;
        }
        StringBuilder buf = new StringBuilder();
        while (l1 != null) {
            buf.append(l1.val);
            l1 = l1.next;
        }
        Long n1 = Long.parseLong(buf.toString());
        buf.delete(0, buf.length());
        while (l2 != null) {
            buf.append(l2.val);
            l2 = l2.next;
        }
        return n1 * Long.parseLong(buf.toString());
    }
}
