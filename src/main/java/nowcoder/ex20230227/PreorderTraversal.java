package nowcoder.ex20230227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 18:48
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        PreorderTraversal demo = new PreorderTraversal();
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-2);
        root.left= left;
        TreeNode right = new TreeNode(2);
        root.right = right;
        int[] nums = demo.preorderTraversal(root);
        System.out.println(Arrays.toString(nums));
    }

    public int[] preorderTraversal(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> nums = new ArrayList<>();
        preOrder(root, nums);
        return nums.stream().mapToInt(i -> i).toArray();
    }

    private void preOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        nums.add(root.val);
        preOrder(root.left, nums);
        preOrder(root.right, nums);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
