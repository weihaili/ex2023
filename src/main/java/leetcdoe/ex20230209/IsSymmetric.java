package leetcdoe.ex20230209;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 10:13
 */
public class IsSymmetric {

    public static void main(String[] args) {
        IsSymmetric demo = new IsSymmetric();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2, null, new TreeNode(3)));
        boolean flag = demo.isSymmetric(root);
        System.out.println(flag);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean checkForDfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    private boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null || u.val != v.val) {
                return false;
            }
            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }
}
