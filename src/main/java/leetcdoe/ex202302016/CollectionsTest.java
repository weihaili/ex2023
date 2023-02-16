package leetcdoe.ex202302016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/16 9:46
 */
public class CollectionsTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> syncList = Collections.synchronizedList(list);

        List<Integer> sfList = new CopyOnWriteArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();;

        int n = 1;
        n |= n >>> 1;
        System.out.println(n);


        int size = tableSizeFor(33);
        System.out.println(size);

        Map<Integer, Integer> cmap  = new ConcurrentHashMap();

        ClassLoader cl;
    }
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
