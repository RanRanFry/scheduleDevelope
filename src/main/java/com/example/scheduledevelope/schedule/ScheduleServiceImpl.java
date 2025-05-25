package com.example.scheduledevelope.schedule;

import com.example.scheduledevelope.scheduleDto.GetScheduleLIstDto;
import com.example.scheduledevelope.scheduleDto.PostScheduleRequestDto;
import com.example.scheduledevelope.scheduleDto.ResponseDto;
import com.example.scheduledevelope.scheduleDto.UpdateScheduleDto;
import com.example.scheduledevelope.entity.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScheduleServiceImpl implements ScheduleService {

    //속성
    private final ScheduleRepository scheduleRepository;

    //생성자

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    //기능

    /**
     * 일정생성
     */
     @Override
    public ResponseDto createScehedule(PostScheduleRequestDto postDto) {
        Schedule schedule = new Schedule(postDto);
         return scheduleRepository.save(schedule);
    }

    /**
     * 일정 리스트 생성
     * @param getListDto
     */
    @Override
    public List<Schedule> getListAPI(GetScheduleLIstDto getListDto) {
         return  scheduleRepository.getListAPI(getListDto);
    }


    /**
     * 일정 단건 조회
     */
    public Schedule findById(Long id){
        return scheduleRepository.findById(id);
    }


    /**
     * 수정
     * @param updateDto
     */
    @Override
    public ResponseDto updateSchedule(Long id, UpdateScheduleDto updateDto) {
        return scheduleRepository.updateSchedule(id, updateDto);
    }

    /**
     * 삭제
     * @param id
     */
    @Override
    public void deleteOne(Long id) {
        scheduleRepository.deleteOne(id);
    }
}
