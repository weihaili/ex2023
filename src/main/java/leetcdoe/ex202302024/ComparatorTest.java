package leetcdoe.ex202302024;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 14:02
 */
public class ComparatorTest {

    public static void main(String[] args) {
        ComparatorTest demo = new ComparatorTest();
        int[] arr = {1,5,2,3,8,0,5,7,6};
        demo.ascArr(arr);
        System.out.println(Arrays.toString(arr));
        demo.desc(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void desc(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private void ascArr(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}
