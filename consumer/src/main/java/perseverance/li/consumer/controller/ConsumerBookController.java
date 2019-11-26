package perseverance.li.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import perseverance.li.entities.Book;
import perseverance.li.entities.User;

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

    private static final String REST_PREFIX_BOOK = "http://PROVIDER-BOOKS/";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/book/add")
    public Boolean add(@RequestBody Book book) {
        ResponseEntity<Boolean> reponse = restTemplate.postForEntity(REST_PREFIX_BOOK + "/book/add",
                book, Boolean.class);
        System.out.println(reponse.toString());
        return reponse.getBody();
    }

    @DeleteMapping("/consumer/book/del/{id}")
    public Boolean del(@PathVariable("id") Integer id) {
        ResponseEntity<Boolean> exchange = restTemplate.exchange(REST_PREFIX_BOOK + "/book/del/" + id,
                HttpMethod.DELETE, null, Boolean.class);
        return exchange.getBody();
    }

    @PutMapping("/consumer/book/update")
    public Boolean update(@RequestBody Book book) {
        HttpEntity<Book> httpEntity = new HttpEntity<>(book);
        ResponseEntity<Boolean> exchange = restTemplate.exchange(REST_PREFIX_BOOK + "/book/update",
                HttpMethod.PUT, httpEntity, Boolean.class);
        return exchange.getBody();
    }

    @GetMapping("/consumer/book/get/{id}")
    public Book get(@PathVariable("id") Integer id) {
        Book book = restTemplate.getForObject(REST_PREFIX_BOOK + "/book/get/" + id, Book.class);
        return book;
    }

    @GetMapping("/consumer/book/list")
    public List<Book> list() {
        String url = REST_PREFIX_BOOK + "/book/list";
        List forObject = restTemplate.getForObject(url, List.class);
        return forObject;
    }
}
