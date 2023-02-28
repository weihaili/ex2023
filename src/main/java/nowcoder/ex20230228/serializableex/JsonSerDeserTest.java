package nowcoder.ex20230228.serializableex;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 14:03
 */
public class JsonSerDeserTest {

    public static void main(String[] args) {
        JsonSerDeserTest demo = new JsonSerDeserTest();
        UserVO user = new UserVO("liyunlong", 55, "BJ", 'M');
        System.out.println(user.toString());
        byte[] arr = demo.serialize(user);
        System.out.println(arr.length);
        UserVO deUser = demo.deserialize(arr);
        System.out.println(deUser.toString());
    }

    private UserVO deserialize(byte[] arr) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.readValue(arr, UserVO.class);
        } catch (IOException e) {
            System.err.println("deserialize IOException " + e.getMessage());
        }
        return null;
    }

    private byte[] serialize(UserVO user) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsBytes(user);
        } catch (JsonProcessingException e) {
            System.err.println("serialize JsonProcessingException " + e.getMessage());
        }
        return new byte[0];
    }
}
