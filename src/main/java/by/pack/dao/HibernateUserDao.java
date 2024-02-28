package by.pack.dao;

import by.pack.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Optional;

public class HibernateUserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public void save(User user){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email){
    Session currentSession = sessionFactory.getCurrentSession();
    Query<User> query = currentSession.createQuery("from User where email = :email", User.class);
    query.setParameter("email", email);
    try {
        return Optional.of(query.getSingleResult());
    }catch (NoResultException e){
        return Optional.empty();
    }
    }
}
