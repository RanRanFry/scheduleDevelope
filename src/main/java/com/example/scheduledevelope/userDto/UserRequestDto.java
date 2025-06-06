package com.example.scheduledevelope.userDto;

import lombok.Getter;

@Getter
public class UserRequestDto {
    private String userName;
    private String email;

    public UserRequestDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
