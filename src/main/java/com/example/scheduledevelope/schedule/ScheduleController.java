package com.example.scheduledevelope.schedule;

import com.example.scheduledevelope.scheduleDto.GetScheduleLIstDto;
import com.example.scheduledevelope.scheduleDto.PostScheduleRequestDto;
import com.example.scheduledevelope.scheduleDto.ResponseDto;
import com.example.scheduledevelope.scheduleDto.UpdateScheduleDto;
import com.example.scheduledevelope.entity.Schedule;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;




@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    //속성

    private final ScheduleService scheduleService;


    //생성자 -> 의존성 주입
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    //기능

    /**
     *
     * 일정 생성
     */
    @PostMapping()
    public ResponseEntity <ResponseDto> createSchedule(@RequestBody PostScheduleRequestDto postDto){
        return new ResponseEntity<> (scheduleService.createScehedule(postDto), HttpStatus.CREATED);
    }

    /**
     *  일부 리스트 조회
     * @param userName
     * @param date
     */
    @GetMapping
    public List <Schedule> getScheduleListAPI(

            @RequestParam(required= false) String userName,
            @RequestParam(required= false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date//리퀘스트파람 사용하는 방법을 모르겠다.
    ){
        GetScheduleLIstDto getScheduleList = new GetScheduleLIstDto(userName, date);
        List<Schedule> scheduleList = scheduleService.getListAPI(getScheduleList);

      return scheduleList;
    }


    /**
     * 일정 단건 조회
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleAPI(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.findById(id), HttpStatus.FOUND);
    }

    /**
     * 수정
     */
    @PatchMapping("/{id}")
    public ResponseEntity <ResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody UpdateScheduleDto updateDto
    ){
        return new ResponseEntity<>(scheduleService.updateSchedule(id, updateDto), HttpStatus.ACCEPTED);
    }


    /**
     * 삭제
     */
    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id){
        scheduleService.deleteOne(id);
    }

}
