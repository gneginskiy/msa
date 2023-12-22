package com.otus.msa.controller;

import com.otus.msa.model.dto.UserDto;
import com.otus.msa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(UserController.USER_API_URL)
@RequiredArgsConstructor
public class UserController {
    public static final String USER_API_URL = "/api/v1/users";
    private final UserService userService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto user) {
        return userService.create(user);
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDto update(@PathVariable UUID id, @RequestBody UserDto user) {
        return userService.update(user.setId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Collection<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public UserDto get(@PathVariable UUID id) {
        return userService.get(id);
    }
}
