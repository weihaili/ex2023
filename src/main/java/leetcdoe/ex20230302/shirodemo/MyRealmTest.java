package leetcdoe.ex20230302.shirodemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 16:33
 */
public class MyRealmTest {

    public MyRealm myRealm = new MyRealm();

    @Test
    public void testAuthorizate() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("kkl", "123456");
        subject.login(token);

        System.out.println("isAuthenticated : " + subject.isAuthenticated());

        subject.checkRoles("admin", "user");
        subject.checkPermission("user:add");
    }
}
