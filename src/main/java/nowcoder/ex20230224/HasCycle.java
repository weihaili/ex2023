package nowcoder.ex20230224;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 17:35
 */
public class HasCycle {

    public static void main(String[] args) {
        HasCycle demo = new HasCycle();
        ListNode root = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        boolean flag = demo.hasCycle(root);
        System.out.println(flag);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
