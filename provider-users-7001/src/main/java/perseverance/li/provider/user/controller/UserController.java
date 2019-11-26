package perseverance.li.provider.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import perseverance.li.entities.User;
import perseverance.li.provider.user.service.impl.UserService;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-26 16:20
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-26 16:20 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/get/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @GetMapping("/user/list")
    public List<User> list() {
        return userService.list();
    }
}
