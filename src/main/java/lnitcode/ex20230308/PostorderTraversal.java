package lnitcode.ex20230308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 17:29
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        PostorderTraversal demo = new PostorderTraversal();
        TreeNode root = new TreeNode(0, new TreeNode(-1), new TreeNode(1));
        List<Integer> res = demo.postorderTraversal(root);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(res, root);
        return res;
    }

    private void postOrder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(res, root.left);
        postOrder(res, root.right);
        res.add(root.val);
    }
}
