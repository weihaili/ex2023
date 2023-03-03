package nowcoder.ex20230303;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/3 18:38
 */
public class LevelOrder {

    public static void main(String[] args) {
        LevelOrder demo = new LevelOrder();
        TreeNode root = new TreeNode(0, new TreeNode(-1), new TreeNode(1));
        ArrayList<ArrayList<Integer>> res = demo.levelOrder(root);
        for (ArrayList<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        while (!que.isEmpty()) {
            ArrayList<Integer> nums = new ArrayList<>();
            int levelSize = que.size();
            for (int i = 0; i < levelSize; ++i) {
                TreeNode node = que.poll();
                nums.add(node.val);
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            res.add(nums);
        }
        return res;
    }
}

class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;

  TreeNode(int value) {
      val = value;
  }

    TreeNode(int value, TreeNode left, TreeNode right) {
        val = value;
        this.left = left;
        this.right = right;
    }

}
