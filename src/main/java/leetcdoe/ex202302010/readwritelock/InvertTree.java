package leetcdoe.ex202302010.readwritelock;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 13:36
 */
public class InvertTree {
    public static void main(String[] args) {
        InvertTree demo = new InvertTree();
        TreeNode root = new TreeNode(0, new TreeNode(-1), new TreeNode(1));
        demo.preorderPrint(root);
        TreeNode newRoot = demo.invertTreeByDfs(root);
        System.out.println("8*****************************");
        demo.preorderPrint(newRoot);
    }

    private void preorderPrint(TreeNode newRoot) {
        if (newRoot == null) {
            System.out.println("newRoot is null");
        }
        List<Integer> res = new ArrayList<>();
        preorder(res, newRoot);
        System.out.println(Arrays.asList(res.toArray()));
    }

    private void preorder(List<Integer> res, TreeNode newRoot) {
        if (newRoot == null) {
            return;
        }
        res.add(newRoot.val);
        preorder(res, newRoot.left);
        preorder(res, newRoot.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode ln = invertTree(root.left);
        TreeNode rn = invertTree(root.right);
        root.left = rn;
        root.right = ln;
        return root;
    }

    public TreeNode invertTreeByDfs(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int len = stack.size();
            for (int i = 0; i < len; ++i) {
                TreeNode cur = stack.pop();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }
        }
        return root;
    }

    public TreeNode invertTreeByLayerOrder(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
