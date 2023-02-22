package leetcdoe.ex202302022;

import java.util.ArrayDeque;
import java.util.Deque;



/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 12:01
 */
public class MyQueue {
    private Deque<Integer> inStack;

    private Deque<Integer> outStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()) {
            transfer();
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()) {
            transfer();
        }
        return outStack.peek();
    }

    private void transfer() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
