package leetcdoe.ex20230119;

import java.util.*;

public class DeleteDuplicates {

    public static void main(String[] args) {
        DeleteDuplicates demo = new DeleteDuplicates();
        /*ListNode head = new ListNode(1, new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(1))))));
        ListNode res = demo.deleteDuplicates(head);
        demo.printLinkedVal(res);

        ListNode newHead = demo.reverseList(head);
        demo.printLinkedVal(newHead);*/


        /*ListNode root = new ListNode(2, new ListNode(1,
            new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))))));
        ListNode newRoot = demo.removeElements(root, 1);
        demo.printLinkedVal(newRoot);*/

        /*ListNode list1 = new ListNode(2, new ListNode(1,
                new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))))));
        ListNode list2 = new ListNode(2, new ListNode(1,
                new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))))));
        ListNode mergRes = demo.mergeTwoLists(list1, list2);
        demo.printLinkedVal(mergRes);*/


        /*ListNode cirLinkedNode = new ListNode(2, new ListNode(1,
                new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))))));
        ListNode cirNode1 = new ListNode(1);
        cirLinkedNode.next = cirNode1;
        cirNode1.next = cirLinkedNode;
        boolean res = demo.hasCycle(cirNode1);
        System.out.println(res);*/

        ListNode l1 = new ListNode(1,new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(9,new ListNode(9, new ListNode(6)));
        ListNode numNode = demo.addTwoNumbers(l1, l2);
        demo.printLinkedVal(numNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    private void printLinkedVal(ListNode res) {
        StringBuilder strBuf = new StringBuilder();
        while (res != null) {
            strBuf.append(" ").append(res.val);
            res = res.next;
        }
        System.out.println(strBuf.length() > 0 ? strBuf.substring(1) : "");
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode newRoot = null;
        boolean existNewRootFlag = false;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val == val) {
                if (prev != null) {
                    prev.next = next;
                } else {
                    curr.next = null;
                }
            } else {
                if (!existNewRootFlag) {
                    newRoot = curr;
                    existNewRootFlag = true;
                }
                prev = curr;
            }
            curr = next;
        }
        return newRoot;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }



    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> dic = new HashSet<>();
        ListNode curNode = head;
        dic.add(curNode.val);
        while (curNode.next != null) {
            if (dic.add(curNode.next.val)) {
                curNode = curNode.next;
            } else {
                curNode.next = curNode.next.next;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
