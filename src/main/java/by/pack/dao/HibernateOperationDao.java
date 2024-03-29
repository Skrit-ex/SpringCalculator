package by.pack.dao;

import by.pack.entity.Operation;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Optional;

@Component
public class HibernateOperationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Operation operation) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(operation);
    }

    @Transactional(readOnly = true)
    public Optional<Operation> findByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Operation> operationQuery = currentSession.createQuery("from Operation where email = :email order by desc", Operation.class);
        operationQuery.setParameter("email", email);
        try {
            return Optional.of(operationQuery.getSingleResult());
        }
        catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Transactional
    public Operation findById(long id){
        Session currentSession = sessionFactory.getCurrentSession();
        return  currentSession.get(Operation.class, id);
    }

}
