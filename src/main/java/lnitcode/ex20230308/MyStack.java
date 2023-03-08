package lnitcode.ex20230308;

import java.util.LinkedList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 16:51
 */
public class MyStack {

    public static void main(String[] args) {
        MyStack demo = new MyStack();
        demo.push(1);
        demo.pop();
        demo.push(2);
        System.out.println(demo.top());
        demo.pop();
        System.out.println(demo.isEmpty());
        demo.push(3);
        System.out.println(demo.isEmpty());
    }

    private LinkedList<Integer> data = new LinkedList<>();

    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        data.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        data.removeLast();
    }

    /*
     * @return: An integer
     */
    public int top() {
        return data.getLast();
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
