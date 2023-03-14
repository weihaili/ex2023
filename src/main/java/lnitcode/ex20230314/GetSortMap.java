package lnitcode.ex20230314;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 15:13
 */
public class GetSortMap {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Haly", 21));
        list.add(new Student("Jerry", 31));
        list.add(new Student("Fualy", 28));
        list.add(new Student("Tony", 33));
        list.add(new Student("Jimi", 37));
        Map<Student, Integer> map = getSortMap(list);
        for (Entry<Student, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() + " : " + entry.getValue());
        }
    }

    public static Map<Student, Integer> getSortMap(List<Student> list) {
        Map<Student, Integer> map  = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.age == o2.age) {
                    return o1.name.compareTo(o2.name);
                }
                return o1.age - o2.age;
            }
        });
        if (list == null || list.size() == 0) {
            return map;
        }
        for (int i = 0; i < list.size(); ++i) {
            map.put(list.get(i), i);
        }
        return map;
    }
}

class Student {
    String name;
    int age;
    public Student(String name, int age) {
        this.name= name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "[name: " + name + ", age: " + age + "]";
    }
}
