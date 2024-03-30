package com.bmu.university.manager;

import com.bmu.university.dto.UserDto;
import com.bmu.university.entity.UserEntity;
import com.bmu.university.mapper.UserMapper;
import com.bmu.university.repository.UserRepository;
import com.bmu.university.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {
    private UserRepository userRepository;


    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> users = userRepository.findAll();
        List<UserDto> userDtos =  users.stream().map((user)-> UserMapper.mapToUserDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void createUser(UserDto userDto) {
        UserEntity user = UserMapper.mapToUserEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public UserDto getUserId(Long userId) {

        UserEntity user = userRepository.findById(userId).get();
        UserDto userDto = UserMapper.mapToUserDto(user);
        return userDto;
    }

    @Override
    public void updateUser(UserDto userDto) {
        userRepository.save(UserMapper.mapToUserEntity(userDto));


    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
