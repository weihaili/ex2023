package leetcdoe.ex202302028;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 16:25
 */
public class DeleteNode {

    public static void main(String[] args) {
        DeleteNode demo = new DeleteNode();
        TreeNode root = new TreeNode(0, new TreeNode(-1), new TreeNode(1));
        TreeNode node = demo.deleteNode(root, 1);
        System.out.println(node.val);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode suc = root.right;
            while (suc.left != null) {
                suc = suc.left;
            }
            root.right = deleteNode(root.right, suc.val);
            suc.right = root.right;
            suc.left = root.left;
            return suc;
        }
        return root;
    }
}
