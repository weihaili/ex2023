package lnitcode.ex20230308;

import java.util.LinkedList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 16:45
 */
public class MyQueue {

    public static void main(String[] args) {
        MyQueue que = new MyQueue();
        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        System.out.println(que.dequeue());
        que.enqueue(4);
        System.out.println(que.dequeue());
    }

    private LinkedList<Integer> data = new LinkedList<>();

    public void enqueue(int item) {
        data.offer(item);
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        if (data.size() == 0) {
            return -1;
        }
        return data.removeFirst();
    }
}
