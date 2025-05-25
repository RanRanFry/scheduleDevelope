package com.example.scheduledevelope.user;


import com.example.scheduledevelope.entity.User;
import com.example.scheduledevelope.schedule.ScheduleService;
import com.example.scheduledevelope.userDto.UserRequestDto;
import com.example.scheduledevelope.userDto.UserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    //속성
    private final UserService userService;
    private final ScheduleService scheduleService;

    //생성자
    public UserController(UserService userService, ScheduleService scheduleService) {this.userService = userService;
        this.scheduleService = scheduleService;
    }

    //기능

    /**
     * 유저 생성
     */
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
         UserResponseDto saveOne = userService.createUser(userRequestDto);
         return new ResponseEntity <>(saveOne,HttpStatus.CREATED);
    }

    /**
     * 유저 전체 조회
     */
    @GetMapping("/findAll")
    public void findAll( ){
        List<User> all = userService.findAll();
        for(User u : all){
            System.out.println("id = " + u.getId());
            System.out.println("name = " + u.getUserName());
        }

    }

    /**
     * 유저 단건 조회
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity <User> findOne(@PathVariable Long id){
        return new ResponseEntity<> ( userService.findOne(id), HttpStatus.FOUND);
    }

    /**
     * 수정
     */

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto userDto
    ) {
        UserResponseDto userResponseDto = userService.updateAccount(id, userDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /**
     * 삭제
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){ userService.deleteUser(id);}
}
