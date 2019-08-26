package ru.stqa.pft.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.mantis.model.UsersData;
import ru.stqa.pft.mantis.model.Users;
import java.util.List;

public class DbHelper {

    private final SessionFactory sessionFactory;
    private ApplicationManager app;

    public DbHelper(ApplicationManager app) {
        this.app = app;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    public Users users() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UsersData> result = session.createQuery("from UsersData where username != 'administrator'").list();
        for (UsersData user : result) {
            System.out.println(user);
        }
        session.getTransaction().commit();
        session.close();
        return new Users(result);
    }
}
