package com.example.scheduledevelope.user;

import com.example.scheduledevelope.userDto.UserRequestDto;
import com.example.scheduledevelope.userDto.UserResponseDto;
import com.example.scheduledevelope.entity.User;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  UserRepository extends JpaRepository <User, Long>, UserRepostioryCustom {

}
