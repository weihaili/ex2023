package leetcdoe.ex20230208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Description: preorder traversal root -> left -> right
 *
 * @author Admin
 * @date 2023/2/8 11:05
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        PreorderTraversal demo = new PreorderTraversal();
        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        List<Integer> res = demo.preorderTraversal(root);
        if (res == null) {
            System.out.println("res is null");
        }
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode p1 = root;
        TreeNode p2 = null;
        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            }else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }

    public List<Integer> preorderTraversalByIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    public List<Integer> preorderTraversalByRecrusion(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }


    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
