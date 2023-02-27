package leetcdoe.ex202302027;


import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 18:11
 */
public class ReorderList {

    public static void main(String[] args) {
        ReorderList demo = new ReorderList();
        ListNode root = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        demo.reorderList(root);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            ++i;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            --j;
        }
        list.get(i).next = null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

