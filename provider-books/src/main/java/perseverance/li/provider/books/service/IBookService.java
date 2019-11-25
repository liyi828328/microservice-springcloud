package perseverance.li.provider.books.service;

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
public interface IBookService {

    /**
     * 添加
     *
     * @param book
     * @return
     */
    boolean add(Book book);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Book get(Integer id);

    /**
     * 获取全部
     *
     * @return
     */
    List<Book> list();

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    Integer del(Integer id);

    /**
     * 更新
     *
     * @param book
     * @return
     */
    Integer update(Book book);

}
