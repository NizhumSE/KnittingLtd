package com.client.newsBlog.mapper.Interface;

public interface TriFunction <T, U, V, R>{
    R apply(T t, U u, V v);
}
