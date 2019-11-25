package perseverance.li.provider.entities;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2019-11-22 10:47
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-22 10:47 : Create by LiYi
 * ---------------------------------------------------------------
 */
public class Book {

    private Integer id;
    private String name;
    private String author;
    private String publicationDate;
    private String introduction;

    public Book() {

    }

    public Book(Integer id, String name, String author, String publicationDate, String introduction) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
        this.introduction = introduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
