package nowcoder.ex20230227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 19:13
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        PostorderTraversal demo = new PostorderTraversal();
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-1);
        root.left = left;
        TreeNode right = new TreeNode(1);
        root.right = right;
        int[] nums = demo.postorderTraversal(root);
        System.out.println(Arrays.toString(nums));
    }

    public int[] postorderTraversal (TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> nums = new ArrayList<>();
        postorder(root, nums);
        return nums.stream().mapToInt(i -> i).toArray();
    }

    private void postorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        postorder(root.left, nums);
        postorder(root.right, nums);
        nums.add(root.val);
    }
}
