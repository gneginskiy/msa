package com.otus.msa.service;

import com.otus.msa.converter.UnifiedMapper;
import com.otus.msa.model.dto.UserDto;
import com.otus.msa.repository.UserRepository;
import com.otus.msa.service.validator.UserServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserServiceValidator userServiceValidator;
    private final UnifiedMapper mapper;

    public UserDto create(UserDto dto) {
        userServiceValidator.validateCreate(dto);
        return mapper.toDto(userRepository.save(mapper.toEntity(dto)));
    }

    public UserDto update(UserDto dto) {
        userServiceValidator.validateUpdate(dto);
        return mapper.toDto(userRepository.save(mapper.toEntity(dto)));
    }

    public void delete(UUID id) {
        userServiceValidator.validateDelete(id);
        userRepository
                .deleteById(id);
    }

    public Collection<UserDto> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public UserDto get(UUID id) {
        userServiceValidator.validateGet(id);
        return userRepository
                .findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }
}
