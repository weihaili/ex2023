package leetcdoe.ex20230119;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectFillNext {

    public static void main(String[] args) {
        ConnectFillNext demo = new ConnectFillNext();
        Node root = null;
        Node res = demo.connect(root);
        System.out.println(res);
    }

    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                if (i < size - 1) {
                    curNode.next = queue.peek();
                }

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
        return root;
    }
}

class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
