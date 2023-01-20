package leetcdoe.creaetpattern.prototypemodel;

import java.io.*;

public class SheepForDeepCopy implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String color;
    private String address;

    public SheepForDeepCopy friend;

    public SheepForDeepCopy(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public SheepForDeepCopy getFriend() {
        return friend;
    }

    public void setFriend(SheepForDeepCopy friend) {
        this.friend = friend;
    }

    public SheepForDeepCopy deepCopy() {
        SheepForDeepCopy sdc = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            sdc = (SheepForDeepCopy)ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return sdc;
    }

    @Override
    public String toString() {
        return "SheepForDeepCopy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                ", friend=" + friend.hashCode() +
                '}';
    }
}
