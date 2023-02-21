package nowcoder.ex20230221;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 18:11
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        GetLeastNumbers demo = new GetLeastNumbers();
        ArrayList<Integer> nums = demo.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4);
        System.out.println(Arrays.toString(nums.toArray()));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k > input.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>(k);
        Arrays.sort(input);
        for (int i = 0; i < k; ++i) {
            list.add(input[i]);
        }
        return list;
    }
}
