package com.otus.msa.converter;

import com.otus.msa.model.dto.UserDto;
import com.otus.msa.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UnifiedMapper {
    //product mappers
    public abstract UserDto toDto(UserEntity entity);
    public abstract UserEntity toEntity(UserDto dto);
}
