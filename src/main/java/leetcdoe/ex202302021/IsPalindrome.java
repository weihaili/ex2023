package leetcdoe.ex202302021;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 11:41
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome demo = new IsPalindrome();
        ListNode one1 = new ListNode(-129);
        ListNode two1 = new ListNode(-129);
        one1.next = two1;
        ListNode two2 = new ListNode(-129);
        two1.next = two2;
        ListNode one2 = new ListNode(-129);
        two2.next = one2;
        boolean flag = demo.isPalindrome(one1);
        System.out.println(flag);
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            ++front;
            --back;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            int val = head.val;
            if (!stack.isEmpty() && stack.peek() == val) {
                stack.pop();
            } else {
                stack.push(val);
            }
            head = head.next;
        }
        return stack.isEmpty();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
