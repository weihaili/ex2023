package lnitcode.ex20230314;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 14:02
 */
public class PriorityTest {

    public static void main(String[] args) {
        PriorityTest demo = new PriorityTest();
        List<Person> list = new ArrayList<>();
        list.add(new Person("Jack", 21, 0));
        list.add(new Person("Jimi", 69, 1));
        list.add(new Person("July", 52, 2));
        list.add(new Person("July", 42, 3));
        list.add(new Person("Jane", 70, 4));
        demo.priority(list);
    }

    public void priority(List<Person> list) {
        PriorityQueue<Person> queue = new PriorityQueue<>(new PersonComparator());
        for (Person person : list) {
            queue.offer(person);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().toString());
        }
    }

    class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            if ((o1.age < 5 || o1.age > 60) && (o2.age >= 5 && o2.age <= 60)) {
                return -1;
            }
            if ((o1.age >= 5 && o1.age <= 60) && (o2.age < 5 || o2.age > 60)) {
                return 1;
            }
            return o1.number - o2.number;
        }
    }
}

class Person {
    String name;
    int age;
    int number;
    public Person(String name, int age, int number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }
    public String toString() {
        return "number = " + number + ", name = " + name + ", age = " + age;
    }

}

