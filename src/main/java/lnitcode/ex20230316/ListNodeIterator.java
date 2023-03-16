package lnitcode.ex20230316;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 17:50
 */
public class ListNodeIterator {

    // write your code here
    private ListNode head;

    private ListNode cur;

    ListNodeIterator(ListNode node) {
        // write your code here
        head = node;
        cur = new ListNode(-1);
        cur.next = head;
    }

    boolean hasNext() {
        // write your code here
        return cur.next != null;
    }

    ListNode next() {
        // write your code here
        return hasNext() ? (cur = cur.next) : null;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNodeIterator getIterator() {
        return new ListNodeIterator(this);
    }

    @Override
    public String toString() {
        return "" + this.val;
    }
}