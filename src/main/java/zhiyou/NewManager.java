package zhiyou;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.security.auth.login.AppConfigurationEntry;
import java.util.List;
//AppConfigurationEntry javax.security.auth.login.Configuration;

/**
 * Created by zhiyou on 15-5-26.
 */
public class NewManager {
        Session session = BuildUnilt.getSessionFactory().openSession();//创建session,通过BuildUnilt类封装创建sessionfactory

        private void add(){//内部函数只是本类调用，可以设置成私有的

                //开始事物
                Transaction tx = session.beginTransaction();
                //创建消息对象
                Techer t = new Techer();
                //设置消息标题和消息内容
                t.setName("李四");

                //保存消息
                session.save(t);
                //提交事物
                tx.commit();
                //关闭Session
                session.close();
             //   BuildUnilt.getSessionFactory().close();
        }
        private void delect(){
              //  Session session = BuildUnilt.getSessionFactory().openSession();//创建session,通过BuildUnilt类封装创建sessionfactory

                Transaction tx = session.beginTransaction();
                //创建消息对象
               Techer t = (Techer)session.get(Techer.class,Long.valueOf(1));//直接通过session的get方法，获取要删除的id，在那个类中，valuesof的参数是主键id
               //直接用session中的delect()方法来删除
               session.delete(t);
                //保存消息
              //  session.save(t);
                //提交事物
                tx.commit();
                //关闭Session
                session.close();
        }
        private void update(){
           //     Session session = BuildUnilt.getSessionFactory().openSession();//创建session,通过BuildUnilt类封装创建sessionfactory

                Transaction tx = session.beginTransaction();
                //创建消息对象
                Techer t = (Techer)session.get(Techer.class,Long.valueOf(3));//直接通过session的get方法，获取要删除的id，在那个类中，valuesof的参数是主键id
               t.setName("张靓颖");//给指定的id重新赋值
                session.save(t);//save就是更新数据库中的属性值

                //保存消息
                //  session.save(t);
                //提交事物
                tx.commit();
                //关闭Session
                session.close();
        }
        private void allnumber(){
                Transaction tx = session.beginTransaction();
                //创建消息对象
                Techer t = (Techer)session.get(Techer.class,Long.valueOf(3));//直接通过session的get方法，获取要删除的id，在那个类中，valuesof的参数是主键id
               String hql = "from Techer";//使用hql面向对象的sql
                Query query = session.createQuery(hql);//Query类用的是org.hibernate包下的
               List<Techer> techerList= query.list();//获取所有的可以获取的数据,获取了数据口中的数据的集合，techerlist
                for(Techer techer:techerList){//遍历集合
                        System.out.println(techer);
                }
                tx.commit();
                //关闭Session
                session.close();
        }

    public static void main(String args[]) throws Exception {
//        Configuration configuration = new Configuration().configure();//当调用configure方法时会自动加载*/cfg/xml文件
//
//        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//
//        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);//获取Session工厂
                NewManager newManager = new NewManager();
          //  newManager.add();添加值根据id
          //  newManager.delect();删除值根据id
             //   newManager.update();//更新数据库中的值
                newManager.allnumber();
    }
}
