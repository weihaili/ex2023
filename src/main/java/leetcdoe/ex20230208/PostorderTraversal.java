package leetcdoe.ex20230208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Description: postorder tracersal : left ->right -> root
 *
 * @author Admin
 * @date 2023/2/8 13:48
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        PostorderTraversal demo = new PostorderTraversal();
        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        List<Integer> res = demo.postorderTraversal(root);
        if (res == null) {
            System.out.println("res is null");
        }
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
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
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                    addPath(res, p1.left);
                }
            }
            p1 = p1.right;
        }
        addPath(res, root);
        return res;
    }

    private void addPath(List<Integer> res, TreeNode root) {
        int count = 0;
        while (root != null) {
            ++count;
            res.add(root.val);
            root = root.right;
        }
        int left = res.size() - count;
        int right = res.size() - 1;
        while (left < right) {
            Integer temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }

    public List<Integer> postorderTraversalByIterator(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> postorderTraversalByRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
