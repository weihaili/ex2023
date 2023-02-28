package nowcoder.ex20230228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 18:58
 */
public class PrintListFromTailToHead {

    public static void main(String[] args) {
        PrintListFromTailToHead demo = new PrintListFromTailToHead();
        ListNode root = new ListNode(0);
        ListNode next = new ListNode(1);
        root.next = next;
        ArrayList<Integer> nums = demo.printListFromTailToHead(root);
        System.out.println(Arrays.toString(nums.toArray()));
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}