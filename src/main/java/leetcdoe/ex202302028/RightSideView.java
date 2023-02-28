package leetcdoe.ex202302028;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 15:19
 */
public class RightSideView {

    public static void main(String[] args) {
        RightSideView demo = new RightSideView();
        TreeNode root = new TreeNode(0, new TreeNode(-1), new TreeNode(1));
        List<Integer> nums = demo.rightSideView1(root);
        System.out.println(Arrays.toString(nums.toArray()));
    }

    public List<Integer> rightSideView1(TreeNode root) {
        Map<Integer, Integer> depthAndValMap = new HashMap<>();
        int maxDepth = -1;
        Queue<TreeNode> nodeQue = new LinkedList<>();
        Queue<Integer> depthQue = new LinkedList<>();
        nodeQue.add(root);
        depthQue.add(0);
        while (!nodeQue.isEmpty()) {
            TreeNode node = nodeQue.remove();
            int depth = depthQue.remove();
            if (node != null) {
                maxDepth = Math.max(maxDepth, depth);
                depthAndValMap.put(depth, node.val);
                if (node.left != null) {
                    nodeQue.add(node.left);
                    depthQue.add(depth + 1);
                }
                if (node.right != null) {
                    nodeQue.add(node.right);
                    depthQue.add(depth + 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= maxDepth; ++i) {
            list.add(depthAndValMap.get(i));
        }
        return list;
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> valAndDepthMap = new HashMap<>();
        int maxDepth = -1;

        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        nodeStack.add(root);
        depthStack.add(0);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (node != null) {
                maxDepth = Math.max(maxDepth, depth);
                if (!valAndDepthMap.containsKey(depth)) {
                    valAndDepthMap.put(depth, node.val);
                }
                if (node.left != null) {
                    nodeStack.push(node.left);
                    depthStack.push(depth + 1);
                }
                if (node.right != null) {
                    nodeStack.push(node.right);
                    depthStack.push(depth + 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= maxDepth; ++i) {
            list.add(valAndDepthMap.get(i));
        }
        return list;
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
