package com.example.scheduledevelope.userDto;

import com.example.scheduledevelope.entity.User;
import lombok.Getter;


@Getter
public class UserResponseDto  {
    private Long id;
    private String userName;
    private String email;


    public UserResponseDto(User user) {
        this.id =user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }


            ;
}
