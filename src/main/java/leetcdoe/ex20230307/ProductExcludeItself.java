package leetcdoe.ex20230307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 18:25
 */
public class ProductExcludeItself {

    public static void main(String[] args) {
        ProductExcludeItself demo = new ProductExcludeItself();
        List<Integer> nums = Arrays.asList(1,2,3);
        List<Long> res = demo.productExcludeItself(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Long> productExcludeItself(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return new ArrayList<>();
        }
        int size = nums.size();
        Long[] res = new Long[size];
        for (int i = 0; i < size; i++) {
            long num = 1L;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                num *= nums.get(j);
            }
            res[i] = num;
        }
        return Arrays.asList(res);
    }
}
