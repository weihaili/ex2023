package nowcoder.ex20230222;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 17:33
 */
public class MoreThanHalfNum {

    public static void main(String[] args) {
        MoreThanHalfNum demo = new MoreThanHalfNum();
        int num = demo.MoreThanHalfNum_Solution(new int[]{3,3,3,3,2,2,2});
        System.out.println(num);
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        return array[array.length >> 1];
    }
}
