package org.example.api.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractRepository <T> implements Repository<T> {

    protected final List<T> storage = new ArrayList<>();

    /**
     *
     * @return storage as a List of entities
     */
    @Override
    public List<T> findAll() {
        return storage;
    }

    /**
     *
     * @param entity
     */
    @Override
    public void save(T entity) {
        if (isValid(entity)) {
            storage.add(entity);
        } else {
            throw new IllegalArgumentException("Invalid item");
        }
    }

    /**
     *
     * @param item
     * @return
     */
    protected abstract boolean isValid(T item);
}
