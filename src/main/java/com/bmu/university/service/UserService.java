package com.bmu.university.service;

import com.bmu.university.dto.UserDto;

import java.util.List;

public interface UserService {
        List<UserDto> getAll();

        void createUser(UserDto userDto);

        UserDto getUserId(Long userId);

        void updateUser(UserDto userDto);

        void deleteById(Long id);
}
