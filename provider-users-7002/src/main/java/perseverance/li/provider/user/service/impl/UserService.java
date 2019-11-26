package perseverance.li.provider.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perseverance.li.entities.User;
import perseverance.li.provider.user.dao.UserDao;
import perseverance.li.provider.user.service.IUserService;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-26 16:18
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-26 16:18 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User get(Integer id) {
        return userDao.queryUser(id);
    }

    @Override
    public List<User> list() {
        return userDao.queryAllUser();
    }
}
