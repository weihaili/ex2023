package leetcdoe.ex20230302.rmidemo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 14:53
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService {

    protected UserServiceImpl() throws RemoteException {}

    @Override
    public User findUser(String userId) throws RemoteException {
        if ("001".equals(userId)) {
            User user = new User();
            user.setAge(18);
            user.setName("kkl");
            user.setSkill("java");
            return user;
        }
        throw new RemoteException("No one has been found");
    }
}
