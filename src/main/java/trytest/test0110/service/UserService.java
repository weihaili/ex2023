package trytest.test0110.service;

import trytest.test0110.dao.UserDao;
import trytest.test0110.entity.User;

public interface UserService {

    User getUser();

    void setDao(UserDao dao);
}
