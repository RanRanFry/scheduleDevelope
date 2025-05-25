package com.example.scheduledevelope.user;


import com.example.scheduledevelope.userDto.UserRequestDto;
import com.example.scheduledevelope.userDto.UserResponseDto;
import com.example.scheduledevelope.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    // 1. 속성
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // 기능

    /**
     * 생성
     * @param userRequestDto
     * @return
     */
    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {

        User user = new User(userRequestDto.getUserName(), userRequestDto.getEmail());

        UserResponseDto savedUser = userRepository.createUser(user);

        return savedUser;
    }


    /**
     * 전체 조회
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    /**
     * 단건 조회
     * @param id
     */
    @Override
    public User findOne(Long id ) {
        User foundOne = userRepository.findOne(id);
        return foundOne;
    }

    /**
     * 수정
     */
    public  UserResponseDto updateAccount( Long id, UserRequestDto userDto){
        return userRepository.updateAccount(id, userDto);
    }

    @Override
    public void deleteUser(Long id) { userRepository.deleteUser(id); }

}
