package perseverance.li.consumer.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import perseverance.li.consumer.feign.service.FeignBookService;
import perseverance.li.entities.Book;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-22 14:39
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-22 14:39 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@RestController
public class ConsumerBookController {

    @Autowired
    private FeignBookService bookService;

    @GetMapping("/consumer/book/get/{id}")
    public Book get(@PathVariable("id") Integer id) {
        return bookService.get(id);
    }

    @GetMapping("/consumer/book/list")
    public List<Book> list() {
        return bookService.list();
    }
}
