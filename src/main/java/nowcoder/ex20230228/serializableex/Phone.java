package nowcoder.ex20230228.serializableex;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 13:29
 */
public class Phone implements Serializable {

    private static int size = 20;

    private transient String brand;

    private String name;

    private String color;

    public Phone(String brand, String name, String color) {
        this.brand = brand;
        this.name = name;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream oos) {
        System.out.println("writeObject .....");
        try {
            oos.defaultWriteObject();
            oos.writeObject(name);
        } catch (IOException e) {
            System.err.println("writeObject ioserr " + e.getMessage());
        }
    }

    private void readObject(ObjectInputStream oi) {
        try {
            oi.defaultReadObject();
            name = (String)oi.readObject();
        } catch (IOException e) {
            System.err.println("readObject ioserr " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("readObject ClassNotFoundException " + e.getMessage());
        }
    }
}
