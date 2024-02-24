package com.basics.amazon.learnSpringBoot.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericMapper {


    private static ModelMapper modelMapper;

    @Autowired
    public GenericMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static <E, D> D entityToDto(E entity, Class<D> DtoClass) {
        return modelMapper.map(entity, DtoClass);
    }

    public static <D, E> E DtoToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

}

