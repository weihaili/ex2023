package lnitcode.ex20230314;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 17:25
 */
public class Test {

    public static void main(String[] args) {
        Test demo = new Test();
        long res = demo.testLong(10L);
        System.out.println(res);
        long val = demo.pow(4);
        System.out.println(val);
    }

    private long pow(int i) {
        if (i < 1) {
            return 0;
        }
        int val = 1;
        while (i > 1) {
            val *= i;
            --i;
        }
        return val;
    }

    private long testLong(long i) {
        if (i < 1) {
            return 0;
        }
        return (1 + i) * i >> 1;
    }
}
