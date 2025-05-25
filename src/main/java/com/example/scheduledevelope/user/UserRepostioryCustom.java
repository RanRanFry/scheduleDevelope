package com.example.scheduledevelope.user;

import com.example.scheduledevelope.entity.User;
import com.example.scheduledevelope.userDto.UserRequestDto;
import com.example.scheduledevelope.userDto.UserResponseDto;

import java.util.List;

public interface UserRepostioryCustom {
    UserResponseDto createUser(User user);

    List<User> findAll();

    User findOne(Long id);

    UserResponseDto updateAccount(Long id, UserRequestDto userDto);

    void deleteUser(Long id);
}
