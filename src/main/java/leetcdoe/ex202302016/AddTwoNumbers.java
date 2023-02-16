package leetcdoe.ex202302016;


import io.swagger.models.auth.In;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/16 15:59
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers demo = new AddTwoNumbers();
        ListNode l1 = new ListNode(6, new ListNode(1, new ListNode(2)));
        ListNode l2 = new ListNode(2, new ListNode(9, new ListNode(5)));
        ListNode root = demo.addTwoNumbers(l1, l2);
        System.out.println(root.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int add = 0;
        while(l1 != null || l2 != null){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + add;
            add = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(add != 0){
            cur.next = new ListNode(add);
        }

        return pre.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int n1 = this.getNumByListNode(l1);
        int n2 = this.getNumByListNode(l2);
        n1 = n1 + n2;
        String nums = "" + n1;
        ListNode dummy = new ListNode(0);
        ListNode root = dummy;
        for (int i = nums.length() - 1; i >= 0; --i) {
            ListNode cur = new ListNode(Integer.valueOf(nums.substring(i,i + 1)));
            root.next = cur;
            root = cur;
        }
        return dummy.next;
    }

    private int getNumByListNode(ListNode root) {
        StringBuilder buf = new StringBuilder();
        while (root != null) {
            buf.append(root.val);
            root = root.next;
        }
        if (buf.length() > 0) {
            return Integer.valueOf(buf.toString());
        }
        return 0;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
