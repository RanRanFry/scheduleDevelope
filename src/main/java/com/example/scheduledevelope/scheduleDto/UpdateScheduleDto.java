package com.example.scheduledevelope.scheduleDto;

import lombok.Getter;

@Getter
public class UpdateScheduleDto {

    private String titles;
    private String contents;

    public UpdateScheduleDto() {
    }

    public UpdateScheduleDto(String contents) {
        this.contents = contents;
    }

    public UpdateScheduleDto(String titles, String contents) {
        this.titles = titles;
        this.contents = contents;
    }
}
