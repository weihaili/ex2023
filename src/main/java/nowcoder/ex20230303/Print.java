package nowcoder.ex20230303;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/3 18:51
 */
public class Print {

    public static void main(String[] args) {
        Print demo = new Print();
        TreeNode root = new TreeNode(0, new TreeNode(-1), new TreeNode(1));
        ArrayList<ArrayList<Integer>> res = demo.Print(root);
        for (ArrayList<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        que.add(pRoot);
        boolean flag = true;
        while (!que.isEmpty()) {
            ArrayList<Integer> nums = new ArrayList<>();
            int size = que.size();
            if (flag) {
                TreeNode node = que.removeFirst();
                nums.add(node.val);

            } else {
                TreeNode node = que.removeLast();
            }
        }
        return res;
    }
}
