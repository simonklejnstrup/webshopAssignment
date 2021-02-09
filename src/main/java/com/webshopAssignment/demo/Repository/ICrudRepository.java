package com.webshopAssignment.demo.Repository;

import java.util.List;

public interface ICrudRepository<T> {
    void create(T t);
    List<T> readAll();
    T read(long id);
    void update(T t);
    void delete(long id);
}
