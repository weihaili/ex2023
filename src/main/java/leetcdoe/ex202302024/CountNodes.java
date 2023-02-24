package leetcdoe.ex202302024;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 9:42
 */
public class CountNodes {

    public static void main(String[] args) {
        CountNodes demo = new CountNodes();
        TreeNode root = new TreeNode(0, new TreeNode(1), new TreeNode(2));
        int cnt = demo.countNodes(root);
        System.out.println(cnt);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lf = countNodes(root.left);
        int rn = countNodes(root.right);
        return lf + rn + 1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
