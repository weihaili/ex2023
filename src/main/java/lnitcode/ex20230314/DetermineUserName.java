package lnitcode.ex20230314;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 16:50
 */
public class DetermineUserName {

    public boolean determineUserName(Object object1, Object object2) {
        if (object1 instanceof Student && object2 instanceof Student) {
            Student s1 = (Student) object1;
            Student s2 = (Student) object2;
            if (s1.getName().equals(s2.getName()) && s1.getAge() != s2.getAge()) {
                return true;
            }
        }
        if (object1 instanceof Teacher && object2 instanceof Teacher) {
            Teacher t1 = (Teacher) object1;
            Teacher t2 = (Teacher) object2;
            if (t1.getName().equals(t2.getName()) && t1.getAge() != t2.getAge()) {
                return true;
            }
        }
        return false;
    }
}

class Teacher {
    private int age;
    private String name;

    public Teacher() {

    }

    public Teacher(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
