package leetcdoe.ex20230302.rmidemo;

import java.io.Serializable;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 14:49
 */
public class User implements Serializable {

    private String name;

    private Integer age;

    private String skill;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skill='" + skill + '\'' +
                '}';
    }
}
