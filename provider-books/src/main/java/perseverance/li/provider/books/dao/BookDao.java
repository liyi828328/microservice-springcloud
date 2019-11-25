package perseverance.li.provider.books.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
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
@Mapper
@Component
public interface BookDao {

    @Insert("INSERT INTO books (name,author,publication_date,introduction) VALUES (#{name},#{author},#{publicationDate},#{introduction})")
    boolean addBook(Book book);

    @Delete("DELETE FROM books WHERE id = #{id}")
    Integer delBook(Integer id);

    @Select("SELECT * FROM books WHERE id = #{id}")
    Book queryBook(Integer id);

    @Select("SELECT * FROM books")
    List<Book> queryAllBook();

    @Update("UPDATE books SET name=#{name} , author=#{author} , publication_date=#{publicationDate} , introduction=#{introduction}  WHERE id=#{id}")
    Integer updateBook(Book book);
}
