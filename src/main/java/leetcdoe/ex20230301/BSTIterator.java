package leetcdoe.ex20230301;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/1 18:28
 */
public class BSTIterator {

    private List<Integer> nums;

    private int idx;

    public BSTIterator(TreeNode root) {
        idx = 0;
        nums = new ArrayList<>();
        inorder(root, nums);
    }

    public int next() {
        return nums.get(idx++);
    }

    public boolean hasNext() {
        return idx < nums.size();
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
