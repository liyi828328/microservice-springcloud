package perseverance.li.entities;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-26 16:10
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-26 16:10 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String dataSource;

    public User() {
    }

    public User(Integer id, String name, Integer age, String dataSource) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dataSource = dataSource;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
}
