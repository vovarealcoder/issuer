package ru.issuer.dao.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import ru.issuer.dao.repository.BaseRepository;
import ru.issuer.dao.repository.DaoException;

import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;


public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {

    private SessionFactory sessionFactory;

    @Autowired
    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int create(T entity) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        Serializable savedId = session.save(entity);
        if (savedId != null) {
            return (Integer) savedId;
        }
        throw new DaoException("Insertion error");
    }


    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    T querySingle(String queryString, Class<T> clazz, Object... parameter) {
        try {
            Query<T> query = createQuery(queryString, clazz, parameter);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    List<T> queryList(String queryString, Class<T> clazz, Object... parameter) {
        try {
            Query<T> query = createQuery(queryString, clazz, parameter);
            return query.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    private Query<T> createQuery(String queryString, Class<T> clazz, Object[] parameter) {
        Session session = sessionFactory.openSession();
        Query<T> query = session.createQuery(queryString, clazz);
        for (int i = 1; i <= parameter.length; i++) {
            query.setParameter(i, parameter[i - 1]);
        }
        return query;
    }
}
