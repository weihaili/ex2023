package lnitcode.ex20230313;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 15:53
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        PreorderTraversal demo = new PreorderTraversal();
        TreeNode root = new TreeNode(0, new TreeNode(1), new TreeNode(2));
        List<Integer> result = demo.preorderTraversal(root);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    private void preorder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(res, root.left);
        preorder(res, root.right);
    }
}
