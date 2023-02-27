package nowcoder.ex20230227;

import org.apache.activemq.store.kahadb.disk.index.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 19:08
 */
public class InorderTraversal {

    public static void main(String[] args) {
        InorderTraversal demo = new InorderTraversal();
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-1);
        root.left = left;
        TreeNode right = new TreeNode(1);
        root.right = right;
        int[] nums = demo.inorderTraversal(root);
        System.out.println(Arrays.toString(nums));
    }

    public int[] inorderTraversal (TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        return nums.stream().mapToInt(i -> i).toArray();
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
