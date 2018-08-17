package com.ycwang.repository;

import java.util.List;

/**
 * @author ycwang.
 * @date 2018-8-17.
 */
public interface IDataSource<T> {

    void add(T t);

    void delete(T t);

    void update(T t);

    List<T> queryAll();

    T queryById(int id);


}

