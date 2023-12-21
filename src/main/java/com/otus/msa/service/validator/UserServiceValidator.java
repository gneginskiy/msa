package com.otus.msa.service.validator;

import com.otus.msa.model.dto.UserDto;
import com.otus.msa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceValidator {
    private final UserRepository userRepository;

    public void validateCreate(UserDto dto) {

    }

    public void validateUpdate(UserDto dto) {

    }

    public void validateDelete(UUID id) {

    }

    public void validateGet(UUID id) {

    }
}
