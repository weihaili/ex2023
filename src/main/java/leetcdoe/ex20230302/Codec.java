package leetcdoe.ex20230302;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 17:47
 */
public class Codec {

    public static void main(String[] args) {
        Codec demo = new Codec();
        TreeNode root = new TreeNode(0, new TreeNode(-1), new TreeNode(1));
        String str = demo.serialize(root);
        System.out.println(str);
        TreeNode node = demo.deserialize(str);
        System.out.println(node.val);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder buf = new StringBuilder();
        return rserialize(root, buf);
    }

    private String rserialize(TreeNode root, StringBuilder buf) {
        if (root == null) {
            buf.append("None").append(",");
        } else {
            buf.append(root.val).append(",");
            rserialize(root.left, buf);
            rserialize(root.right, buf);
        }
        return buf.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(arr));
        return rdeserialize(dataList);
    }

    private TreeNode rdeserialize(List<String> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return null;
        }
        if ("None".equals(dataList.get(0))) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
        return root;
    }
}
