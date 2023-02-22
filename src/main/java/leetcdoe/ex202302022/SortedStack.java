package leetcdoe.ex202302022;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 13:36
 */
public class SortedStack {

    private Stack<Integer> mStack;

    private Stack<Integer> fStack;

    public SortedStack() {
        mStack = new Stack<>();
        fStack = new Stack<>();
    }

    public void push(int val) {
        while (!mStack.isEmpty() && val > mStack.peek()) {
            fStack.push(mStack.pop());
        }
        mStack.push(val);
        while (!fStack.isEmpty()) {
            mStack.push(fStack.pop());
        }
    }

    public void pop() {
        mStack.pop();
    }

    public int peek() {
        if (!mStack.isEmpty()) {
            return mStack.peek();
        }
        return - 1;
    }

    public boolean isEmpty() {
        return mStack.isEmpty();
    }

}

class SortedStack1 {

    private PriorityQueue<Integer> que;

    public SortedStack1() {
        que = new PriorityQueue<Integer>();
    }

    public void push(int val) {
        que.offer(val);
    }

    public void pop() {
        que.poll();
    }

    public int peek() {
        if (que.isEmpty()) {
            return -1;
        }
        return que.peek();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }
}
