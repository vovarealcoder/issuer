package ru.issuer.web.model;

public interface WebModel<T> {
    T toORMModel();
}
