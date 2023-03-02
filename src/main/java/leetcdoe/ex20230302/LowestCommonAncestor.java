package leetcdoe.ex20230302;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 17:04
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        LowestCommonAncestor demo = new LowestCommonAncestor();
        TreeNode root = new TreeNode(0, new TreeNode(-1), new TreeNode(1));
        TreeNode node = demo.lowestCommonAncestor(root, new TreeNode(-1), new TreeNode(1));
        System.out.println(node.val);
    }

    private TreeNode resNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return resNode;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)) {
            resNode = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}
