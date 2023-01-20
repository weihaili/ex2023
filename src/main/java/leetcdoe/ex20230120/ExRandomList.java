package leetcdoe.ex20230120;

import java.util.HashMap;
import java.util.Map;

public class ExRandomList {

    public static void main(String[] args) {
        ExRandomList demo = new ExRandomList();
        Node head = new Node(3);
        head.next = new Node(4);
        head.random = new Node(1);
        Node res = demo.copyRandomList(head);
        System.out.println(res.val);
    }

    Map<Node, Node> cacheMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        if (!cacheMap.containsKey(head)) {
            Node copyNode = new Node(head.val);
            cacheMap.put(head, copyNode);
            copyNode.next = copyRandomList(head.next);
            copyNode.random = copyRandomList(head.random);

        }
        return cacheMap.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return head;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node copyNode = new Node(node.val);
            copyNode.next = node.next;
            node.next = copyNode;
        }

        for (Node node = head; node != null; node = node.next.next) {
            // todo
        }
        return cacheMap.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
