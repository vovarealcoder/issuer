package ru.issuer.dao.repository;

public interface BaseRepository<T> {
    int create(T entity) throws DaoException;

    void delete(T entity) throws DaoException;

    void update(T entity) throws DaoException;
}
