package leetcdoe.ex20230119;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MergeTrees {

    public static void main(String[] args) {
        MergeTrees demo = new MergeTrees();
        TreeNode roo1 = new TreeNode(1);
        TreeNode roo3 = new TreeNode(3);
        TreeNode roo12 = new TreeNode(2);
        TreeNode roo5 = new TreeNode(5);
        roo1.left = roo3;
        roo1.right = roo12;
        roo3.left = roo5;

        TreeNode roo2 = new TreeNode(2);
        TreeNode roo21 = new TreeNode(1);
        TreeNode roo4 = new TreeNode(4);
        TreeNode roo23 = new TreeNode(3);
        TreeNode root7 = new TreeNode(7);
        roo2.left = roo21;
        roo21.right = roo4;
        roo2.right = roo23;
        roo23.right = root7;

        TreeNode newNode = demo.mergeTrees(roo1, roo2);
        System.out.println(newNode);
        demo.printTreeArr(roo1);
        demo.printTreeArr(roo2);
        demo.printTreeArr(newNode);
    }

    private void printTreeArr(TreeNode node) {
        if (node == null) {
            System.out.println("tree is empty...");
        }
        List<TreeNode> nodes = new ArrayList<>();
        appendTreeVal(node, nodes);
        String res = nodes.stream().map(ele -> String.valueOf(ele.val)).collect(Collectors.joining(","));
        System.out.println(res);
    }

    private void appendTreeVal(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(node);
        appendTreeVal(node.left, nodes);
        appendTreeVal(node.right, nodes);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
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

    @Override
    public String toString() {
        return "" + this.val;
    }
}
