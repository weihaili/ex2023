package leetcdoe.ex20230207;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/7 15:46
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MergeTwoLists demo = new MergeTwoLists();
        ListNode list1 = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode list2 = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode newHead = demo.mergeTwoLists(list1, list2);
        System.out.println(newHead.val);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return head.next;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        List<ListNode> nodes = new ArrayList<>();
        while (list1 != null) {
            ListNode next = list1.next;
            nodes.add(list1);
            list1 = next;
        }

        while (list2 != null) {
            ListNode next = list2.next;
            nodes.add(list2);
            list2 = next;
        }
        List<ListNode> resList = nodes.stream().sorted(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        }).collect(Collectors.toList());
        ListNode head = resList.get(0);
        ListNode temp = head;
        for (int i = 0; i < resList.size(); ++i) {
            ListNode node = resList.get(i);
            temp.next = node;
            node = temp;
            if (i == resList.size() - 1) {
                node.next = null;
            }
        }

        return head;
    }
}
