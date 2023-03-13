package lnitcode.ex20230313;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 14:19
 */
public class BinaryTreePathSum {
    public static void main(String[] args) {
        BinaryTreePathSum demo = new BinaryTreePathSum();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(2), new TreeNode(3)), new TreeNode(4));
        List<List<Integer>> res = demo.binaryTreePathSum(root, 3);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        getSumRoates(res, root, target, new ArrayList<Integer>());
        return res;
    }

    private void getSumRoates(List<List<Integer>> res, TreeNode root, int target, ArrayList<Integer> cur) {
        if (root == null) {
            return;
        }
        target -= root.val;
        cur.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(cur));
        }
        if (root.left != null) {
            getSumRoates(res, root.left, target, cur);
        }
        if (root.right != null) {
            getSumRoates(res, root.right, target, cur);
        }
        cur.remove(cur.size() - 1);
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
