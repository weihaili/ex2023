package leetcdoe.ex20230116;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        RemoveNthFromEnd demo = new RemoveNthFromEnd();

        int[] nums = {1,2,3,4,5};
        ListNode head = demo.convertArrToLinkedList(nums);

        int lastN = 6;
        head = demo.removeNthFromEnd(head, lastN);
        ListNode[] res = demo.convertLinkedListToArrNode(head);
        System.out.println(Arrays.toString(res));
    }

    private int getLinkedListLen(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
        }
        return res;
    }

    private ListNode[] convertLinkedListToArrNode(ListNode head) {
        List<ListNode> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head);
            head = head.next;
        }
        int len = vals.size();
        ListNode[] nodeArr = new ListNode[len];
        for (int i = 0; i < len; i++) {
            nodeArr[i] = vals.get(i);
        }
        return nodeArr;
    }

    private ListNode convertArrToLinkedList(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode other = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            other.next = temp;
            other = temp;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] nodes = convertLinkedListToArrNode(head);
        if (nodes == null || nodes.length < 1 || nodes.length < n) {
            return null;
        }
        int len = nodes.length;
        int rmIdx = len - n;
        ListNode rmNode = nodes[rmIdx];
        if (rmIdx == 0) {
            return rmNode.next;
        } else if (rmIdx == len - 1) {
            nodes[len - 2].next = null;
        } else {
            ListNode pre = nodes[rmIdx - 1];
            pre.next = nodes[rmIdx + 1];
        }
        return nodes[0];
    }
}
