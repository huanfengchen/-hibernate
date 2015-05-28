package zhiyou;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by zhiyou on 15-5-27.
 */
public class BuildUnilt {
    private static final SessionFactory sessionFactory = buildsessionFactry();//获得一个Sessionfactory
    private static SessionFactory buildsessionFactry(){//得到了一个SessinFactory对象
        Configuration configuration = new Configuration().configure();//当调用configure方法时会自动加载*/cfg/xml文件

        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);//获取Session工厂

    }

    public static SessionFactory getSessionFactory(){//获取当前的Sessionfactroy
        return sessionFactory;
    }
}
