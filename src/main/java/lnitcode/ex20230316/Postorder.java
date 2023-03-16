package lnitcode.ex20230316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 8:35
 */
public class Postorder {

    public static void main(String[] args) {
        Postorder demo = new Postorder();
        List<UndirectedGraphNode> neighbors = new ArrayList<>();
        neighbors.add(new UndirectedGraphNode(1));
        neighbors.add(new UndirectedGraphNode(2));
        neighbors.add(new UndirectedGraphNode(3));
        UndirectedGraphNode root = new UndirectedGraphNode(0, neighbors);
        List<Integer> res = demo.postorder(root);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> postorder(UndirectedGraphNode root) {
        LinkedList<Integer> res = new LinkedList<>();;
        if (root == null) {
            return res;
        }
        LinkedList<UndirectedGraphNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            UndirectedGraphNode node = nodes.pollLast();
            res.add(node.label);
            List<UndirectedGraphNode> neighbors = node.neighbors;
            if (neighbors != null) {
                for (UndirectedGraphNode temp : node.neighbors) {
                    if (temp != null) {
                        nodes.addFirst(temp);
                    }
                }
            }
        }
        return res;
    }

    /*private void porder(List<UndirectedGraphNode> nodes, List<Integer> res) {
        if (nodes == null) {
            return;
        }
        for (UndirectedGraphNode undirectedGraphNode : root) {

        }
    }*/
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
    }

    UndirectedGraphNode(int x, List<UndirectedGraphNode> neighbors) {
        label = x;
        this.neighbors = neighbors;
    }
}
