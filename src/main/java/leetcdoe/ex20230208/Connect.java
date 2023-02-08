package leetcdoe.ex20230208;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/8 17:14
 */
public class Connect {

    public static void main(String[] args) {
        Connect demo = new Connect();
        Node root = new Node(1, new Node(2), new Node(3), null);
        Node newRoot = demo.connect(root);
        System.out.println(newRoot == null ? "" : newRoot.val);
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node(0);
            Node pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

    public Node connectByBfs(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            Node prev = null;
            for (int i = 0; i < levelCount; ++i) {
                Node node = queue.poll();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
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
