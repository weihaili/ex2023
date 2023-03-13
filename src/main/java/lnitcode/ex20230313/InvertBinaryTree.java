package lnitcode.ex20230313;

import java.util.LinkedList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 15:58
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree demo = new InvertBinaryTree();
        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2));
        demo.invertBinaryTree(root);
        System.out.println(root.val);
    }

    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }
}
