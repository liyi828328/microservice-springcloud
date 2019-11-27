package perseverance.li.consumer.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import perseverance.li.consumer.feign.service.FeignUserService;
import perseverance.li.entities.User;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-26 16:52
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-26 16:52 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@RestController
public class ConsumerUserController {

    @Autowired
    private FeignUserService userService;

    @GetMapping("/consumer/feign/user/get/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @GetMapping("/consumer/feign/user/list")
    public List<User> list() {
        return userService.list();
    }

}
