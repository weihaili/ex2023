package leetcdoe.ex20230307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 17:50
 */
public class Prime {

    public static void main(String[] args) {
        Prime demo = new Prime();
        boolean flag = demo.isPrime(123);
        System.out.println(flag);
        List<Integer> res = demo.prime(5);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> prime(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n; ++i) {
            if (isPrime(i)) {
                res.add(i);
            }
        }
        return res;
    }
    
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
