package leetcdoe.ex20230301;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/1 18:14
 */
public class KthSmallest {

    public static void main(String[] args) {
        KthSmallest demo = new KthSmallest();
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        int num = demo.kthSmallest(root, 1);
        System.out.println(num);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        return nums.get(k - 1);
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
