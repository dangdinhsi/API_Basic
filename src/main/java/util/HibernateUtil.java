package util;

import entity.Hero;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Hero hero = new Hero();
            hero.setName("Tuấn");
            hero.setDescription("đây là bé Tuấn");
            hero.setImage("https://i.ytimg.com/vi/RzZomvqG1Sg/maxresdefault.jpg");
            session.save(hero);
            System.out.println("save success!!!");
            transaction.commit();

        }catch (Exception ex){
            if(transaction!=null){
                transaction.rollback();}

        }finally {
            session.close();
        }

    }
}