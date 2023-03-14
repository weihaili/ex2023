package lnitcode.ex20230314;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 16:04
 */
public class PrintNum {

    public static void main(String[] args) {
        new PrintNum().printNum(3);
    }

    public void printNum(int num) {
        while (num > 0) {
            new TestB();
            --num;
        }
        System.out.println(TestA.num);
    }

}

class TestA {
    static int num = 0;
    static {
        num++;
    }

    {
        num++;
    }

    public TestA(){
        num++;
    }

}

class TestB extends TestA{
    static {
        num++;
    }

    {
        num++;
    }

    public TestB(){
        num++;
    }
}