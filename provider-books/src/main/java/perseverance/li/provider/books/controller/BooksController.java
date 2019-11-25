package perseverance.li.provider.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import perseverance.li.provider.books.service.impl.BookService;
import perseverance.li.provider.entities.Book;

import java.util.List;


/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2019-11-21 20:54
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-21 20:54 : Create by LiYi
 * ---------------------------------------------------------------
 */
@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book/add")
    public Boolean add(@RequestBody Book book) {
        return bookService.add(book);
    }

    @DeleteMapping("/book/del/{id}")
    public Boolean del(@PathVariable("id") Integer id) {
        return bookService.del(id) > 0;
    }

    @PutMapping("/book/update")
    public Boolean update(@RequestBody Book book) {
        return bookService.update(book) > 0;
    }

    @GetMapping("/book/get/{id}")
    public Book get(@PathVariable("id") Integer id) {
        return bookService.get(id);
    }

    @GetMapping("/book/list")
    public List<Book> list() {
        return bookService.list();
    }
}
