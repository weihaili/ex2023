package lnitcode.ex20230313;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 15:24
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths demo = new BinaryTreePaths();
        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2));
        List<String> res = demo.binaryTreePaths(root);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        StringBuilder buf = new StringBuilder();
        buf.append(root.val);
        List<String> res = new ArrayList<>();
        travel(root, buf, res);
        return res;
    }

    private void travel(TreeNode root, StringBuilder buf, List<String> res) {
        if (root == null) {
            return;
        }
        int orgLen = buf.length();
        if (root.left == null && root.right == null) {
            res.add(buf.toString());
            return;
        }
        if (root.left != null) {
            buf.append("->").append(root.left.val);
            travel(root.left, buf, res);
            buf.delete(orgLen, buf.length());
        }
        if (root.right != null) {
            buf.append("->").append(root.right.val);
            travel(root.right, buf, res);
            buf.delete(orgLen, buf.length());
        }
        return;
    }
}
