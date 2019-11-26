package perseverance.li.provider.user.service;

import perseverance.li.entities.User;

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
public interface IUserService {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    User get(Integer id);

    /**
     * 获取全部
     *
     * @return
     */
    List<User> list();
}
