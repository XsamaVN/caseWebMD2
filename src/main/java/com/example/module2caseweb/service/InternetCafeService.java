package com.example.module2caseweb.service;

import java.util.List;

public interface InternetCafeService<T> {
    void addNew(T t);
    int findIndexById(int id);
    T findById(int id);
    List<T> findAll();
    void update(int id, T t);
    void delete(int id);
}
