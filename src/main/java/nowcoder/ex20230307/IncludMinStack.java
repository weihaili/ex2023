package nowcoder.ex20230307;

import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 11:45
 */
public class IncludMinStack {

    private Stack<Integer> dStack = new Stack<>();

    private Stack<Integer> mStack = new Stack<>();

    private int min = Integer.MAX_VALUE;

    //    619
    public void push(int node) {
        dStack.push(node);
        min = Math.min(min, node);
        mStack.push(min);
    }

    public void pop() {
        mStack.pop();
        min = mStack.peek();
        dStack.pop();
    }

    public int top() {
        return dStack.peek();
    }

    public int min() {
        return mStack.peek();
    }
}
