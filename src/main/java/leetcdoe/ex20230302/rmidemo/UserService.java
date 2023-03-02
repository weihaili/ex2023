package leetcdoe.ex20230302.rmidemo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {

    User findUser(String userId) throws RemoteException;
}
