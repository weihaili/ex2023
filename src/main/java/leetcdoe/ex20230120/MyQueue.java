package leetcdoe.ex20230120;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack();
        outStack = new Stack();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            this.transfer();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            this.transfer();
        }
        return outStack.peek();
    }

    private void transfer() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
