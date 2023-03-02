package leetcdoe.ex20230302.rmidemo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 15:02
 */
public class RmiClient {

    public static void main(String[] args) {
        User user;
        String userId = "001";
        try {
            UserService service = (UserService)Naming.lookup("rmi://localhost:1900/user");
            user = service.findUser(userId);
            System.out.println(user.toString());
        } catch (NotBoundException e) {
            System.err.println("RmiClient NotBoundException reason:" + e.getMessage());
        } catch (MalformedURLException e) {
            System.err.println("RmiClient MalformedURLException reason:" + e.getMessage());
        } catch (RemoteException e) {
            System.err.println("RmiClient RemoteException reason:" + e.getMessage());
        }
    }
}
