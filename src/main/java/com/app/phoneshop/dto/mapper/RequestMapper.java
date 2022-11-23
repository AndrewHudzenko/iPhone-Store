package com.app.phoneshop.dto.mapper;

public interface RequestMapper<D, T> {
    T toModel(D d);
}
