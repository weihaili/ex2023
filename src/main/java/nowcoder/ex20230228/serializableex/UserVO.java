package nowcoder.ex20230228.serializableex;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 14:01
 */
public class UserVO {

    private String name;

    private int age;

    private String address;

    private char gender;

    private static String zone = "NJ";

    public UserVO() {
    }

    public UserVO(String name, int age, String address, char gender) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
