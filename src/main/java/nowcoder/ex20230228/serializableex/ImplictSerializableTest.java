package nowcoder.ex20230228.serializableex;

import org.springframework.data.redis.connection.ReactiveRedisConnection.Command;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 11:19
 */
public class ImplictSerializableTest {

    public static void main(String[] args) {
        ImplictSerializableTest demo = new ImplictSerializableTest();
        Computer computer = new Computer();
        computer.setBrand("lenovo");
        computer.setName("lenovo-T470");
        computer.setColor("black");
        computer.setSize(17);
        computer.setSpeFunction("small convenient");
        System.out.println(computer.toString());
        byte[] arr = demo.serialize(computer);

        Computer deCom = demo.deserialize(arr);
        System.out.println(deCom.toString());
    }

    private byte[] serialize(Computer computer) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(computer);
        } catch (IOException e) {
            System.err.println("serialize err " + e.getMessage());
        }
        return bos.toByteArray();
    }

    private Computer deserialize (byte[] arr) {
        ByteArrayInputStream bais = new ByteArrayInputStream(arr);
        ObjectInputStream ois;
        Computer computer = null;
        try {
            ois = new ObjectInputStream(bais);
            computer = (Computer)ois.readObject();
        } catch (IOException e) {
            System.err.println("deserialize Ioeerr " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("deserialize cnfeerr " + e.getMessage());
        }
        return computer;
    }
}
