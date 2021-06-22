package com.lightshell.zen.common;

import java.util.List;

public interface SuperService<T> {

    T save(T t);

    List<T> saveAll(List<T> data);

}
