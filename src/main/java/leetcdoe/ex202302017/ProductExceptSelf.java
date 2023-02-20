package leetcdoe.ex202302017;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/17 15:16
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        ProductExceptSelf demo = new ProductExceptSelf();
        int[] res = demo.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        System.out.println(Arrays.toString(res));
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] lProduct = new int[len];
        int[] rProduct = new int[len];
        int[] res = new int[len];
        lProduct[0] = 1;
        for (int i = 1; i < len; ++i) {
            lProduct[i] = lProduct[i -1] * nums[i - 1];
        }

        rProduct[len - 1] = 1;
        for (int i =len - 2; i >= 0; --i) {
            rProduct[i] = nums[i + 1] * rProduct[i + 1];
        }

        for (int i = 0; i < len; ++i) {
            res[i] = lProduct[i] * rProduct[i];
        }
        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            int product = 1;
            for (int j = 0; j < len; ++j) {
                if (i == j) {
                    continue;
                }
                product *= nums[j];
            }
            res[i] = product;
        }
        return res;
    }

}
