package nowcoder.ex20230228;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 18:32
 */
public class Duplicate {

    public static void main(String[] args) {
        Duplicate demo = new Duplicate();
        int num = demo.duplicate(new int[]{1,2,3,4,5,6,3});
        System.out.println(num);
    }

    public int duplicate (int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
