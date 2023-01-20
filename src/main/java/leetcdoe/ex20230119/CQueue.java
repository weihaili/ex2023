package leetcdoe.ex20230119;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public CQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            return -1;
        }
        if (outStack.isEmpty()) {
            this.transfer();
        }
        return outStack.pop();
    }

    private void transfer() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
