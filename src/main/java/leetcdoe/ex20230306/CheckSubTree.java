package leetcdoe.ex20230306;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 18:07
 */
public class CheckSubTree {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return isTreeEq(t1, t2) || isTreeEq(t1.left, t2) || isTreeEq(t1.right, t2);
    }

    private boolean isTreeEq(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        return isTreeEq(t1.left, t2.left) && isTreeEq(t1.right, t2.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
