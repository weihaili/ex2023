package nowcoder.ex20230228.serializableex;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 11:41
 */
public class Cup implements Externalizable {

    private int heigh;

    private String brand;

    private static boolean isDrink = true;

    private transient String color;

    public Cup() {
    }

    public int getHeigh() {
        return heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cup{" +
                "heigh=" + heigh +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal ...");
        out.writeObject(brand);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("readExternal ...");
        brand = (String)in.readObject();
    }
}
