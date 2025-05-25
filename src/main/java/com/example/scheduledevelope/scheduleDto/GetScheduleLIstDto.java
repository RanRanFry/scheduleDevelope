package com.example.scheduledevelope.scheduleDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScheduleLIstDto {
    private String userName;
    private LocalDateTime updatedAt;

    public GetScheduleLIstDto(String userName, LocalDateTime updatedAt) {
        this.userName = userName;
        this.updatedAt = updatedAt;
    }
}
