package com.bmu.university.mapper;

import com.bmu.university.dto.UserDto;
import com.bmu.university.entity.UserEntity;

public class UserMapper {
    public static UserEntity mapToUserEntity(UserDto userDto){
        UserEntity user = new UserEntity(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail());
        return user;
    }
    public static UserDto mapToUserDto(UserEntity userEntity){
        UserDto userDto = new UserDto(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail()
        );
        return userDto;
    }
}
