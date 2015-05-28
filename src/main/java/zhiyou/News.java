package zhiyou;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by zhiyou on 15-5-26.
 */

public class News {
    private Integer id;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
