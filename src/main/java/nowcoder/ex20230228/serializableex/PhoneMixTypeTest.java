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
 * @date 2023/2/28 13:43
 */
public class PhoneMixTypeTest {

    public static void main(String[] args) {
        PhoneMixTypeTest demo = new PhoneMixTypeTest();
        Phone phone = new Phone("XIAOMI", "k50", "black");
        System.out.println(phone.toString());
        byte[] arr = demo.serialize(phone);
        System.out.println(arr.length);
        Phone dePhone = demo.deserialize(arr);
        System.out.println(dePhone.toString());
    }

    private Phone deserialize(byte[] arr) {
        ByteArrayInputStream bais = new ByteArrayInputStream(arr);
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(bais);
            return (Phone) ois.readObject();
        } catch (IOException e) {
            System.err.println("deserialize ioserr " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("deserialize ClassNotFoundException " + e.getMessage());
        }
        return null;
    }

    private byte[] serialize(Phone phone) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(phone);
            return baos.toByteArray();
        } catch (IOException e) {
            System.err.println("serialize ioserr " + e.getMessage());
        }
        return null;
    }
}
