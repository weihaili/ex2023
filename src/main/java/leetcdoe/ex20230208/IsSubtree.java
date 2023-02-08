package leetcdoe.ex20230208;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/8 17:32
 */
public class IsSubtree {
    public static void main(String[] args) {
        IsSubtree demo = new IsSubtree();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode subRoot = new TreeNode(3, new TreeNode(4), null);
        boolean flag = demo.isSubtree(root, subRoot);
        System.out.println(flag);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    private boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}
