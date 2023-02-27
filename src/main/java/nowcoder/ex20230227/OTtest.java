package nowcoder.ex20230227;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 9:50
 */
public class OTtest {

    public static void main(String[] args) {
        OTtest demo = new OTtest();
        int age = 17;
        System.out.println("maim before change age: "+ age);
        demo.change(age);
        System.out.println("maim after change age: "+ age);

        Map<String, Integer> map = new HashMap<>();
        map.put("aaa", 111);
        System.out.println(map.get("aaa"));
        demo.change(map);
        System.out.println("map change after :"+ map.get("aaa"));

        String name = "hello world";
        demo.change(name);
        System.out.println(name);
    }

    private void change(String name) {
        name = "hello world !!!!";
        System.out.println("name change after: " + name);
    }

    private void change(Map<String, Integer> map) {
        map.put("aaa", 2222);
        System.out.println(map.get("aaa"));
    }

    private void change(int age) {
        age = 18;
        System.out.println("change age: " + age);
    }
}

class NanjingOwl implements AsiaOwl{

    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void walk() {

    }
}

interface AsiaOwl extends Bird1, Bird2, Bird3{
    void eat();
}

interface Bird1{
    void fly();
}

interface Bird2 {
    void fly();
}

interface Bird3 {
    void walk();
}
