package leetcdoe.ex202302027;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 15:42
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        ZigzagLevelOrder demo = new ZigzagLevelOrder();
        TreeNode root = new TreeNode(0, new TreeNode(1), new TreeNode(2));
        List<List<Integer>> res = demo.zigzagLevelOrder(root);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        boolean l2rFlag = true;
        while (!que.isEmpty()) {
            LinkedList<Integer> levelNums = new LinkedList<>();
            int size = que.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = que.poll();
                if (l2rFlag) {
                    levelNums.offerLast(curNode.val);
                } else {
                    levelNums.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    que.offer(curNode.left);
                }
                if (curNode.right != null) {
                    que.offer(curNode.right);
                }
            }
            res.add(levelNums);
            l2rFlag = !l2rFlag;
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
