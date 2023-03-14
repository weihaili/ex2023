package lnitcode.ex20230314;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 8:39
 */
public class PruneTree {

    public static void main(String[] args) {
        PruneTree demo = new PruneTree();
        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(1));
        TreeNode node = demo.pruneTree(root);
        System.out.println(node.val);
    }

    public TreeNode pruneTree(TreeNode root) {
        return hasOne(root) ? root : null;
    }

    private boolean hasOne(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean leftHasOneFlag = hasOne(root.left);
        boolean rightHasOneFlag = hasOne(root.right);
        if (!leftHasOneFlag) {
            root.left = null;
        }
        if (!rightHasOneFlag) {
            root.right = null;
        }
        return root.val == 1 || leftHasOneFlag || rightHasOneFlag;
    }


}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
