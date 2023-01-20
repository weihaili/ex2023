package trytest.test0110;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import trytest.test0110.dao.UserDaoOracleImpl;
import trytest.test0110.entity.User;
import trytest.test0110.service.UserService;
import trytest.test0110.service.impl.UserServiceImpl;

public class UserServiceImplTest {

    @Test
    public void testGetUser() {
        UserService service = new UserServiceImpl();
        service.setDao(new UserDaoOracleImpl());
        User user = service.getUser();
        System.out.println(user.toString());
    }

    @Test
    public void testGetUserByIoc() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = ac.getBean(UserServiceImpl.class);
        User user = service.getUser();
        System.out.println(user);
    }
}
