package model;
import entity.Hero;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class HeroModel {

        public boolean saveHero(Hero hero){
            Transaction transaction = null;
            try(Session session = HibernateUtil.getSession()) {
                transaction = session.beginTransaction();
                session.saveOrUpdate(hero);
                transaction.commit();
                return true;
            }catch (Exception ex){
                if(transaction !=null){
                    transaction.rollback();
                }
                return false;
            }
        }

        public List<Hero> listHero(){
            List<Hero> list = new ArrayList<>();
            try(Session session = HibernateUtil.getSession()) {
                list =session.createQuery("from Hero ",Hero.class).list();
            }catch (Exception ex){
                System.out.println("khong lay dc list dau!!!");
            }
            return list;
        }


}
