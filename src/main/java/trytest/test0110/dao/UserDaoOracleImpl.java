package trytest.test0110.dao;

import consts.Gender;
import trytest.test0110.entity.User;

public class UserDaoOracleImpl implements UserDao {

    @Override
    public User getUser() {
        return new User("oracle", Gender.FEMALE.getCode(), 25);
    }
}
