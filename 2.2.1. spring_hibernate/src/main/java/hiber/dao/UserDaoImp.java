package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> getUserList() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select e from User e", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserByCar(Car car) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("select e from User e where e.car.model = :model and e.car.series = :series", User.class)
                .setParameter("model", car.getModel()).setParameter("series", car.getSeries());
        return query.getSingleResult();
    }

}
