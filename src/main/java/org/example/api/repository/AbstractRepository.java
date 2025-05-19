package org.example.api.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractRepository <T> implements Repository<T> {

    protected final List<T> storage = new ArrayList<>();

    @Override
    public List<T> findAll() {
        return storage;
    }

    @Override
    public void save(T entity) {
        if (isValid(entity)) {
            storage.add(entity);
        } else {
            throw new IllegalArgumentException("Invalid item");
        }
    }

    protected abstract boolean isValid(T item);
}
