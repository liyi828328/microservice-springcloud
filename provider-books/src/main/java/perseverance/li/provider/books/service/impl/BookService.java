package perseverance.li.provider.books.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perseverance.li.provider.books.dao.BookDao;
import perseverance.li.provider.books.service.IBookService;
import perseverance.li.provider.entities.Book;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2019-11-22 10:25
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-22 10:25 : Create by LiYi
 * ---------------------------------------------------------------
 */
@Service
public class BookService implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean add(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public Book get(Integer id) {
        return bookDao.queryBook(id);
    }

    @Override
    public List<Book> list() {
        return bookDao.queryAllBook();
    }

    @Override
    public Integer del(Integer id) {
        return bookDao.delBook(id);
    }

    @Override
    public Integer update(Book book) {
        return bookDao.updateBook(book);
    }
}
