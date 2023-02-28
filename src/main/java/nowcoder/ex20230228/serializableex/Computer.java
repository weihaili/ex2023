package nowcoder.ex20230228.serializableex;

import java.io.Serializable;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 11:15
 */
public class Computer implements Serializable {

    private String brand;

    private int size;

    private transient String name;

    private static boolean isComputer = true;

    private String color;

    private String speFunction;

    public Computer() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public String getSpeFunction() {
        return speFunction;
    }

    public void setSpeFunction(String speFunction) {
        this.speFunction = speFunction;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", speFunction='" + speFunction + '\'' +
                '}';
    }
}
