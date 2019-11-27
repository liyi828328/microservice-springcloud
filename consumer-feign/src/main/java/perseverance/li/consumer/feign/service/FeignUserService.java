package perseverance.li.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import perseverance.li.entities.User;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-27 14:44
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-27 14:44 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@FeignClient(name = "PROVIDER-USERS")
public interface FeignUserService {

    @GetMapping("/user/get/{id}")
    User get(@PathVariable("id") Integer id);

    @GetMapping("/user/list")
    List<User> list();
}
