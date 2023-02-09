package leetcdoe.ex20230209;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 16:35
 */
public class MaxPathSum {

    public static void main(String[] args) {
        MaxPathSum demo = new MaxPathSum();
        TreeNode root = new TreeNode(2, new TreeNode(-1), new TreeNode(1, null, new TreeNode(3)));
        int sum = demo.maxPathSum(root);
        System.out.println(sum);
    }

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxGain(root);
        return res;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lval = Math.max(maxGain(root.left), 0);
        int rval = Math.max(maxGain(root.right), 0);
        int price = root.val + lval + rval;
        res = Math.max(res, price);

        return root.val + Math.max(lval, rval);
    }
}
