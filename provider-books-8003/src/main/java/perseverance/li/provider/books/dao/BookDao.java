package perseverance.li.provider.books.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import perseverance.li.entities.Book;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-22 10:25
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-22 10:25 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@Mapper
@Component
public interface BookDao {

    @Insert("INSERT INTO books (name,author,publication_date,introduction,data_source) VALUES (#{name},#{author},#{publicationDate},#{introduction},#{dataSource})")
    boolean addBook(Book book);

    @Delete("DELETE FROM books WHERE id = #{id}")
    Integer delBook(Integer id);

    @Select("SELECT * FROM books WHERE id = #{id}")
    Book queryBook(Integer id);

    @Select("SELECT * FROM books")
    List<Book> queryAllBook();

    @Update("UPDATE books SET name=#{name} , author=#{author} , publication_date=#{publicationDate} , introduction=#{introduction} , data_source=#{dataSource}  WHERE id=#{id}")
    Integer updateBook(Book book);
}
