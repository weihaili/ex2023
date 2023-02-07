package leetcdoe.ex20230207;

import java.util.Stack;

/**
 * Description: implement queue by stack
 *
 * @author Admin
 * @date 2023/2/7 14:07
 */
public class MyQueue {

    private Stack<Integer> in;

    private Stack<Integer> out;

    public MyQueue(Stack<Integer> in ,Stack<Integer> out) {
        this.in = in;
        this.out = out;
    }

    public void push(int x) {
        in.push(x);
    }

    public Integer pop() {
        if (out.size() == 0) {
            this.transfer();
        }
        return out.pop();
    }

    public int peek() {
        if (out.size() == 0) {
            this.transfer();
        }
        return out.peek();
    }

    private void transfer() {
        if(this.empty()) {
            return;
        }
        while (!in.isEmpty()){
            out.push(in.pop());
        }
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }
}
