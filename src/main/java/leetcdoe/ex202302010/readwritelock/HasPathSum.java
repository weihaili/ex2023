package leetcdoe.ex202302010.readwritelock;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 14:09
 */
public class HasPathSum {

    public static void main(String[] args) {
        HasPathSum demo = new HasPathSum();
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6));
        boolean flag = demo.hasPathSumByBfs(root, 10);
        System.out.println(flag);
    }

    public boolean hasPathSumByBfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nQue = new LinkedList<>();
        Queue<Integer> vQue = new LinkedList<>();
        nQue.offer(root);
        vQue.offer(root.val);
        while (!nQue.isEmpty()) {
            TreeNode curNode = nQue.poll();
            Integer curValue = vQue.poll();
            if (curNode.left == null && curNode.right == null) {
                if (curValue == targetSum) {
                    return true;
                }
                continue;
            }
            if (curNode.left != null) {
                nQue.offer(curNode.left);
                vQue.offer(curNode.left.val + curValue);
            }
            if (curNode.right != null) {
                nQue.offer(curNode.right);
                vQue.offer(curNode.right.val + curValue);
            }
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
