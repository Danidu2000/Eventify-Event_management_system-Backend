package edu.icet.service;

import java.util.List;

public interface CrudService<T> extends SuperService{
    void add(T t);
    void deleteById(Integer id);
    List<T> getAll();
    void update(T t);
    T searchById(Integer id);
}
