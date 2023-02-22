package leetcdoe.ex202302022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 11:12
 */
public class StackOfPlates {
    List<LinkedList> stacks;
    int max_Num = 0;

    public StackOfPlates(int cap) {
        stacks = new ArrayList<LinkedList>();
        max_Num = cap;
    }

    public void push(int val) {
        if (max_Num == 0) {
            return;
        }
        if (stacks.size() == 0) {
            LinkedList<Integer> ls = new LinkedList<Integer>();
            stacks.add(ls);
        }
        LinkedList<Integer> cur_Stack = stacks.get(stacks.size() - 1);
        if (cur_Stack.size() >= max_Num) {
            LinkedList<Integer> ls = new LinkedList<Integer>();
            stacks.add(ls);
        }
        cur_Stack = stacks.get(stacks.size() - 1);
        cur_Stack.add(val);
    }

    public int pop() {
        if (stacks.size() == 0 || max_Num == 0) {
            return -1;
        }
        LinkedList<Integer> cur_Stack = stacks.get(stacks.size() - 1);
        if (cur_Stack.size() == 0) {
            stacks.remove(stacks.size() - 1);
            if (stacks.size() == 0) {
                return -1;
            }
            cur_Stack = stacks.get(stacks.size() - 1);
        }
        int result = cur_Stack.removeLast();
        if (cur_Stack.size() == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return result;
    }

    public int popAt(int index) {
        if (max_Num == 0 || stacks.size() == 0 || index >= stacks.size() || index < 0) {
            return -1;
        }
        LinkedList<Integer> cur_Stack = stacks.get(index);
        int result = -1;
        if (cur_Stack.size() == 0) {
            stacks.remove(index);
            return result;
        } else {
            result = cur_Stack.removeLast();
            if (cur_Stack.size() == 0) {
                stacks.remove(index);
            }
        }
        return result;
    }
}
