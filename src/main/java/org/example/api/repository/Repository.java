package org.example.api.repository;

import java.util.List;

interface Repository<T> {
    List<T> findAll();
    void save(T entity);
}
