package lnitcode.ex20230327;

public class CheckPowerOf2 {

    public static void main(String[] args) {
        CheckPowerOf2 demo = new CheckPowerOf2();
        boolean flag = demo.checkPowerOf2(0);
        System.out.println(flag);
    }

    public boolean checkPowerOf2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
