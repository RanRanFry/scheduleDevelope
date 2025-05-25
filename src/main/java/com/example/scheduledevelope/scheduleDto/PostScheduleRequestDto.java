package com.example.scheduledevelope.scheduleDto;

import lombok.Getter;

@Getter
public class PostScheduleRequestDto {
    //속성
   private String userName;
    private String titles;
    private String contents;


//    생성자

    public PostScheduleRequestDto() {
    }


    public PostScheduleRequestDto(String userName, String titles) {
        this.userName = userName;
        this.titles = titles;
    }

    public PostScheduleRequestDto(String userName, String titles, String contents) {
        this.userName = userName;
        this.titles = titles;
        this.contents = contents;
    }



//기능
}
