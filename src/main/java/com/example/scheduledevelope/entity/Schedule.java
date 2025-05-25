package com.example.scheduledevelope.entity;

import com.example.scheduledevelope.scheduleDto.PostScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String titles;
    private String contents;



    public Schedule(){}

    public Schedule(PostScheduleRequestDto postDto) {
        this.userName = postDto.getUserName();
        this.titles = postDto.getTitles();
        this.contents = postDto.getContents();
    }

    public void changeTitles(String titles) {
        this.titles = titles;
    }

    public void changeContents(String contents) {
        this.contents = contents;
    }

//    public void changeUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
}
