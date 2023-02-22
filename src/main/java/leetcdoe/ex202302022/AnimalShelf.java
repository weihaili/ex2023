package leetcdoe.ex202302022;

import java.util.LinkedList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 14:06
 */
public class AnimalShelf {
    private LinkedList<int[]> catQue;

    private LinkedList<int[]> dogQue;

    public AnimalShelf() {
        catQue = new LinkedList<int[]>();
        dogQue = new LinkedList<int[]>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            catQue.add(animal);
        } else if (animal[1] == 1) {
            dogQue.add(animal);
        }
    }

    public int[] dequeueAny() {
        if (catQue.isEmpty() && dogQue.isEmpty()) {
            return new int[] {-1, -1};
        }
        if (catQue.isEmpty()) {
            return dequeueDog();
        }
        if (dogQue.isEmpty()) {
            return dequeueCat();
        }
        int[] cat = catQue.getFirst();
        int[] dog = dogQue.getFirst();
        return cat[0] >= dog[0] ? dequeueDog() : dequeueCat();
    }

    public int[] dequeueDog() {
        if (!dogQue.isEmpty()) {
            return dogQue.removeFirst();
        } else {
            return new int[]{-1, -1};
        }
    }

    public int[] dequeueCat() {
        if (!catQue.isEmpty()) {
            return catQue.removeFirst();
        } else {
            return new int[] {-1, -1};
        }
    }
}
