package com.mansour.chattingapp.services;

import java.util.List;

public interface BaseService<T, V, J> {
    V create(T t);

    V update(J j, T t);

    void delete(J j);

    V get(J j);

    List<V> getAll();
}
