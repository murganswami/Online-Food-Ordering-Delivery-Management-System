package ms.org.daoimplement;

import ms.org.dao.MenuItemDAO;
import ms.org.model.MenuItem;
import ms.org.model.Restaurant;
import ms.org.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MenuItemDAOImpl implements MenuItemDAO {

    @Override
    public void save(MenuItem item) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(item);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<MenuItem> findByRestaurant(Restaurant restaurant) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MenuItem> query = session.createQuery(
                    "FROM MenuItem m WHERE m.restaurant = :rest", MenuItem.class);
            query.setParameter("rest", restaurant);
            return query.list();
        }
    }

    @Override
    public MenuItem findById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(MenuItem.class, id);
        }
    }
}

