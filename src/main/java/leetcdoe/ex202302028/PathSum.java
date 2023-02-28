package leetcdoe.ex202302028;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 15:59
 */
public class PathSum {

    public static void main(String[] args) {
        PathSum demo = new PathSum();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        List<List<Integer>> res = demo.pathSum(root, 4);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<Integer> path = new LinkedList<>();
        List<List<Integer>> ret = new LinkedList<>();
        dfs(root, targetSum, path, ret);
        return ret;
    }

    private void dfs(TreeNode root, int targetSum, Deque<Integer> path, List<List<Integer>> ret) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, targetSum, path, ret);
        dfs(root.right, targetSum, path, ret);
        path.pollLast();
    }
}
