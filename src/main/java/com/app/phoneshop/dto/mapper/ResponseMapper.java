package com.app.phoneshop.dto.mapper;

public interface ResponseMapper<D, T> {
    D toDto(T t);
}
