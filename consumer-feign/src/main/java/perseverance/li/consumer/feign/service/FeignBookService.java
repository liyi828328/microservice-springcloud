package perseverance.li.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import perseverance.li.entities.Book;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-27 14:43
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-27 14:43 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@FeignClient(name = "PROVIDER-BOOKS")
public interface FeignBookService {

    @GetMapping("/book/get/{id}")
    Book get(@PathVariable("id") Integer id);

    @GetMapping("/book/list")
    List<Book> list();
}
