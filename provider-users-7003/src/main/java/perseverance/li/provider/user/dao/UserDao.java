package perseverance.li.provider.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import perseverance.li.entities.User;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-26 16:12
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-26 16:12 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@Mapper
@Component
public interface UserDao {

    @Select("SELECT * FROM users")
    List<User> queryAllUser();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User queryUser(Integer id);

}
