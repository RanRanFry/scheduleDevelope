package com.example.scheduledevelope.scheduleDto;

import com.example.scheduledevelope.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class ResponseDto {
    private Long id;
    private String userName;
    private String titles;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    public ResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.userName = schedule.getUserName();
        this.titles = schedule.getTitles();
        this.contents = schedule.getContents();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();

    }
}

