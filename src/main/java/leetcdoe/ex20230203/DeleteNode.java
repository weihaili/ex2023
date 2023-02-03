package leetcdoe.ex20230203;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/3 16:49
 */
public class DeleteNode {

    public static void main(String[] args) {
        DeleteNode demo = new DeleteNode();
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(3, new ListNode(4))));
        demo.deleteNode(head);
        StringBuilder buf = new StringBuilder();
        while (head != null) {
            buf.append(" ").append(head.val);
            head = head.next;
        }
        System.out.println(buf.toString());
    }


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
