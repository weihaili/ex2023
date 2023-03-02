package leetcdoe.ex20230302.shirodemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 16:07
 */
public class AuthorizationTest {

    private SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("kkl", "123456", "admin", "user");
    }

    @Test
    public void authorizate() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("kkl", "123456");
        subject.login(token);

        System.out.println("is authenticated: " + subject.isAuthenticated());
        subject.checkRoles("admin", "user");
        System.out.println("authorizate : " + subject.hasRole("admin"));
        subject.logout();
    }
}
