package lnitcode.ex20230316;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 17:58
 */
public class GetAns {

    public static void main(String[] args) {
        GetAns demo = new GetAns();
        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(2), null), new TreeNode(3));
        int ans = demo.getAns(root);
        System.out.println(ans);
    }

    public int getAns(TreeNode root) {
        int cnt = 0;
        if (root == null) {
            return cnt;
        }
        cnt += getAns(root.left);
        cnt += getAns(root.right);
        return cnt + 1;
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
