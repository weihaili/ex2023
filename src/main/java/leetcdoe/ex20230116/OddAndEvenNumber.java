package leetcdoe.ex20230116;

public class OddAndEvenNumber {

    public static void main(String[] args) {
        OddAndEvenNumber demo = new OddAndEvenNumber();
        int num = 12;
        boolean res = demo.isOdd(num);
        System.out.println(res);
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(1));




    }

    private boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}
