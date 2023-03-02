package leetcdoe.ex20230302.rmidemo;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 14:57
 */
public class RmiServer {

    public static void main(String[] args) {
        try {
            UserService service = new UserServiceImpl();
            LocateRegistry.createRegistry(1900);
            Naming.bind("rmi://localhost:1900/user", service);
            System.out.println("server start ,port is 1900");
        } catch (RemoteException e) {
            System.err.println("service register error reason:" + e.getMessage());
        } catch (MalformedURLException e) {
            System.err.println("service register MalformedURLException reason:" + e.getMessage());
        } catch (AlreadyBoundException e) {
            System.err.println("service register AlreadyBoundException reason:" + e.getMessage());
        }
    }
}
