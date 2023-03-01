package nowcoder.ex20230301;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/1 19:15
 */
public class IsPail {

    public static void main(String[] args) {
        IsPail demo = new IsPail();
        ListNode head = new ListNode();
        head.val = -401261;
        ListNode foot = new ListNode();
        foot.val = -401261;
        head.next = foot;

        boolean flag = demo.isPail(head);
        System.out.println(flag);

    }

    public boolean isPail(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int size = nums.size();
        for (int i = 0; i <= size >> 1; ++i) {
            if (!nums.get(i).equals(nums.get(size - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
