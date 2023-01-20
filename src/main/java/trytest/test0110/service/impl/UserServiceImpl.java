package trytest.test0110.service.impl;

import trytest.test0110.dao.UserDao;
import trytest.test0110.dao.UserDaoOracleImpl;
import trytest.test0110.entity.User;
import trytest.test0110.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
    @Override
    public User getUser() {
        return dao.getUser();
    }
}
