package lnitcode.ex20230308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 17:20
 */
public class InorderTraversal {

    public static void main(String[] args) {
        InorderTraversal demo = new InorderTraversal();
        TreeNode root = new TreeNode(0, new TreeNode(-1), new TreeNode(1));
        List<Integer> res = demo.inorderTraversal(root);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res, root);
        return res;
    }

    private void inorder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode (int val) {
        this.val = val;
    }
}
