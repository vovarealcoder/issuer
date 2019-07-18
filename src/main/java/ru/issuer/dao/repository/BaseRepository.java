package ru.issuer.dao.repository;

public interface BaseRepository<T> {
    int create(T entity);

    void delete(T entity);

    void update(T entity);
}
