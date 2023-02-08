package leetcdoe.ex20230208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Description: inorder traversal is : left -> root -> right
 *
 * @author Admin
 * @date 2023/2/8 11:47
 */
public class InorderTraversal {
    public static void main(String[] args) {
        InorderTraversal demo = new InorderTraversal();
        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        List<Integer> res = demo.inorderTraversal(root);
        if (res == null) {
            System.out.println("res is null");
        }
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
              res.add(root.val);
              root = root.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversalByIterator(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public List<Integer> inorderTraversalByRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
