package leetcdoe.ex202302022;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 11:01
 */
public class MinStack {

    private Deque<Integer> vStack;

    private Deque<Integer> mStack;

    public MinStack() {
        vStack = new LinkedList<>();
        mStack = new LinkedList<>();
        mStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        vStack.push(x);
        mStack.push(Math.min(x, mStack.peek()));
    }

    public void pop() {
        vStack.pop();
        mStack.pop();
    }

    public int top() {
        return vStack.peek();
    }

    public int getMin() {
        return mStack.peek();
    }
}
