package leetcdoe.ex20230116;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiddleNode {

    public static void main(String[] args) {
        MiddleNode demo = new MiddleNode();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        ListNode head = demo.converteArrToLinkedList(nums);
        demo.loopLinkedList(head);
        int[] vals = demo.converteLinkedListToArrVal(head);
        System.out.println(Arrays.toString(vals));
        ListNode middleNode = demo.middleNode(head);
        System.out.println(middleNode.val);
    }

    private void loopLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private int[] converteLinkedListToArrVal(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int size = vals.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = vals.get(i);
        }
        return res;
    }

    private ListNode[] converteLinkedListToArrNode(ListNode head) {
        List<ListNode> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head);
            head = head.next;
        }
        int size = vals.size();
        ListNode[] res = new ListNode[size];
        for (int i = 0; i < size; i++) {
            res[i] = vals.get(i);
        }
        return res;
    }

    private ListNode converteArrToLinkedList(int[] nums) {
        if (nums == null || nums.length == 0) {
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

    public ListNode middleNode(ListNode head) {
        ListNode[] listNodes = converteLinkedListToArrNode(head);
        int len = listNodes.length;
        return listNodes[len >> 1];
    }




}

class ListNode {
    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
