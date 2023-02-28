package nowcoder.ex20230228.serializableex;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 11:49
 */
public class CupExplicitTest {

    public static void main(String[] args) {
        CupExplicitTest demo = new CupExplicitTest();
        Cup cup = new Cup();
        cup.setBrand("shuiDi");
        cup.setColor("Black");
        cup.setHeigh(30);
        System.out.println(cup.toString());
        byte[] arr = demo.serialize(cup);
        System.out.println(arr.length);
        Cup decup = demo.deserialize(arr);
        System.out.println(decup.toString());
    }

    private Cup deserialize(byte[] arr) {
        ByteArrayInputStream bis = new ByteArrayInputStream(arr);
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(bis);
            return  (Cup)ois.readObject();
        } catch (IOException e) {
            System.err.println("deserialize ioserr " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("deserialize cnfeserr " + e.getMessage());
        }
        return null;
    }

    private byte[] serialize(Cup cup) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(cup);
        } catch (IOException e) {
            System.err.println("serialize err " + e.getMessage());
        }
        return bos.toByteArray();
    }
}
