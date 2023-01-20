package excollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class CurCollection {

    public static void main(String[] args) {
        Collections collections;
        Collections.synchronizedList(new ArrayList<>());
        Collections.synchronizedSortedSet(new TreeSet<>());
    }
}
