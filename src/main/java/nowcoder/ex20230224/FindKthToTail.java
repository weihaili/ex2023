package nowcoder.ex20230224;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 18:01
 */
public class FindKthToTail {

    public static void main(String[] args) {
        FindKthToTail demo = new FindKthToTail();
        ListNode root = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        ListNode node = demo.FindKthToTail(root, 0);
        System.out.println(node.val);
    }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (k < 1) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (pHead != null) {
            list.add(pHead);
            pHead = pHead.next;
        }
        int size = list.size();
        if (k > size) {
            return null;
        }
        return list.get(size - k);
    }
}
