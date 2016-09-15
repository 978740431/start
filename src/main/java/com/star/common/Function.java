package com.star.common;

public interface Function<E,T> {
    public T callback(E e);
}