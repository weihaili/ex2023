package leetcdoe.ex20230116;

public class OperatorDemo {

    public static void main(String[] args) {
        System.out.println("true ^ true: " + (true ^ true));

        boolean a = true;
        boolean a1 = true;

        boolean a2 = true;

        boolean a3 = true;

        boolean b = false;
        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;

        System.out.println("a | a2 | a3 | b :" + (a | a2 | a3 | b));

        System.out.println("a & a2 & a3 & b :" + (a & a2 & a3 & b));


        System.out.println("a || a2 || a3 || b :" + (a || a2 || a3 || b));

        System.out.println("a && a2 && a3 && b :" + (a && a2 && a3 && b));

    }
}
