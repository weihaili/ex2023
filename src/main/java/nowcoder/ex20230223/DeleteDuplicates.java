package nowcoder.ex20230223;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/23 18:58
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        DeleteDuplicates demo = new DeleteDuplicates();
        ListNode node = demo.deleteDuplicates(null);
        System.out.println(node.val);
    }

    public ListNode deleteDuplicates (ListNode head) {
        ListNode temp = head;
        Set<ListNode> set = new HashSet<>();
        while (head != null && head.next != null) {
            if (set.contains(head)) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return temp;
    }
}

class ListNode {
  int val;
  ListNode next = null;
}
