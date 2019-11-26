package perseverance.li.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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

    private static final String REST_PREFIX_USER = "http://PROVIDER-USERS/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/user/get/{id}")
    public User get(@PathVariable("id") Integer id) {
        User user = restTemplate.getForObject(REST_PREFIX_USER + "/user/get/" + id, User.class);
        return user;
    }

    @GetMapping("/consumer/user/list")
    public List<User> list() {
        String url = REST_PREFIX_USER + "/user/list";
        List forObject = restTemplate.getForObject(url, List.class);
        return forObject;
    }

}
