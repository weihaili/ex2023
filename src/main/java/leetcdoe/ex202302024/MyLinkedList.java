package leetcdoe.ex202302024;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 11:09
 */
public class MyLinkedList {
    int size;
    Node head;

    Node tail;

    public MyLinkedList() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node cur;
        if (index + 1  < size - index) {
            cur = head;
            for (int i = 0; i <= index; ++i) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = 0; i < size - index; ++i) {
                cur = cur.pre;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(0, index);
        Node pred;
        Node succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; ++i) {
                pred = pred.next;
            }
            succ = pred.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; ++i) {
                succ = succ.pre;
            }
            pred = succ.pre;
        }
        ++size;
        Node addNode = new Node(val);
        addNode.pre = pred;
        addNode.next = succ;
        pred.next = addNode;
        succ.pre = addNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node pred;
        Node succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; ++i) {
                pred = pred.next;
            }
            succ = pred.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index - 1; ++i) {
                succ = succ.pre;
            }
            pred = succ.pre.pre;
        }
        --size;
        pred.next = succ;
        succ.pre = pred;
    }
}

class Node {
    int val;

    Node pre;

    Node next;

    public Node(int val) {
        this.val = val;
    }
}
