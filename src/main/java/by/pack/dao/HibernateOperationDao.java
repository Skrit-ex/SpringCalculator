package by.pack.dao;

import by.pack.entity.Operation;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class HibernateOperationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Operation operation){
        Session currentSession =sessionFactory.getCurrentSession();
        currentSession.save(operation);
    }
    @Transactional(readOnly = true)
    public List<Operation> findByUser(long id){
    Session currentSession = sessionFactory.getCurrentSession();
     Query<Operation> operationQuery =currentSession.createQuery("from Operation where user_id= : id order by desc" , Operation.class);
    return operationQuery.getResultList();
    }

}
