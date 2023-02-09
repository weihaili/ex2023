package leetcdoe.ex20230209;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 9:57
 */
public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth demo = new MaxDepth();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4)));
        int depth = demo.maxDepth(root);
        System.out.println(depth);
    }

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                --size;
            }
            ++depth;
        }
        return depth;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
