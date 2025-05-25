package com.example.scheduledevelope.schedule;


import com.example.scheduledevelope.scheduleDto.GetScheduleLIstDto;
import com.example.scheduledevelope.scheduleDto.ResponseDto;
import com.example.scheduledevelope.scheduleDto.UpdateScheduleDto;
import com.example.scheduledevelope.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {

    ResponseDto save(Schedule schedule);

    List<Schedule> getListAPI(GetScheduleLIstDto getListDto);

    Schedule findById(Long id);

    ResponseDto updateSchedule(Long id, UpdateScheduleDto updateDto);

    void deleteOne(Long id);

}
