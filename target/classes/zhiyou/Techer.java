package zhiyou;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zhiyou on 15-5-27.
 */
@Entity
@Table(name = "techer")
public class Techer {

    private String name;

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native",strategy = "native")//声明id是主键且是自增的,对谁注解就放在谁的上面
    private long id;

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Techer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
