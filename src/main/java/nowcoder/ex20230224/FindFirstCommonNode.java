package nowcoder.ex20230224;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 18:34
 */
public class FindFirstCommonNode {

    public static void main(String[] args) {
        FindFirstCommonNode demo = new FindFirstCommonNode();
        ListNode root1 = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode root2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode node = demo.FindFirstCommonNode(root1, root2);
        System.out.println(node.val);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (!set.add(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }
}
