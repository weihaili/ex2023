package lnitcode.ex20230313;

import java.util.LinkedList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 14:55
 */
public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth demo = new MaxDepth();
        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2));
        int depth = demo.maxDepth(root);
        System.out.println(depth);
    }

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public int maxDepth1(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                --size;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ++depth;
        }
        return depth;
    }

}
