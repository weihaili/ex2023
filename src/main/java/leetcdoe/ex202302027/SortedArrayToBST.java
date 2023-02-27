package leetcdoe.ex202302027;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 17:10
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        SortedArrayToBST demo = new SortedArrayToBST();
        TreeNode node = demo.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(node.val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + right >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }
}
