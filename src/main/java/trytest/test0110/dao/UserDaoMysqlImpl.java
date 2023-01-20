package trytest.test0110.dao;

import consts.Gender;
import trytest.test0110.entity.User;

public class UserDaoMysqlImpl implements UserDao {

    @Override
    public User getUser() {
        return new User("mysql", Gender.FEMALE.getCode(), 20);
    }
}
