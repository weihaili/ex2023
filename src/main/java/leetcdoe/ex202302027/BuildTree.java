package leetcdoe.ex202302027;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 16:20
 */
public class BuildTree {

    public static void main(String[] args) {
        BuildTree demo = new BuildTree();
        int[] preOrder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = demo.buildTree1(preOrder, inorder);
        if (root == null) {
            System.out.println("root is null");
        }
        System.out.println(root.val);
    }

    private Map<Integer, Integer> indexMap = null;
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }

        indexMap = new HashMap<>();
        int len = preorder.length;
        for (int i = 0; i < len; ++i) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeByPreInOrder(preorder, inorder, 0, len - 1, 0, len -1);
    }

    private TreeNode buildTreeByPreInOrder(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        if (preL > preR) {
            return null;
        }
        int preRootIdx = preL;
        int inRootIdx = indexMap.get(preorder[preRootIdx]);
        TreeNode root = new TreeNode(preorder[preRootIdx]);
        int lsubTreeNodeCnt = inRootIdx - inL;
        root.left = buildTreeByPreInOrder(preorder, inorder, preL + 1, preL + lsubTreeNodeCnt, inL, inRootIdx - 1);
        root.right = buildTreeByPreInOrder(preorder, inorder, preL + lsubTreeNodeCnt + 1, preR, inRootIdx + 1, inR);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIdx = 0;
        for (int i = 1; i < preorder.length; ++i) {
            int preOrderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIdx]) {
                node.left = new TreeNode(preOrderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIdx]) {
                    node = stack.pop();
                    ++inorderIdx;
                }
                node.right = new TreeNode(preOrderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
