package com.example.scheduledevelope.schedule;

import com.example.scheduledevelope.scheduleDto.GetScheduleLIstDto;
import com.example.scheduledevelope.scheduleDto.ResponseDto;
import com.example.scheduledevelope.scheduleDto.UpdateScheduleDto;
import com.example.scheduledevelope.entity.Schedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    //속성 : 기억 안 남
    private final EntityManagerFactory emf;

    //생성자
    public ScheduleRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }


    //기능
    @Override
    public ResponseDto save(Schedule schedule) {

        //1. 엔티티 매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        //2. 트랜잭션 준비
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //3. 저장
        entityManager.persist(schedule);

        //트랜잭션 커밋
        transaction.commit();

        //4.entityManager 정리
        entityManager.close();

        ResponseDto responseDto  = new ResponseDto(schedule);

        return responseDto;
    }

    /**
     * 일정 필터 조회
     * @param getListDto
     */
    @Override
    public List <Schedule> getListAPI(GetScheduleLIstDto getListDto) {
        // 1. 엔티티 매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        //2. 조회-JPQL
        List<Schedule> scheduleList = entityManager.createQuery("SELECT s FROM Schedule s WHERE s.userName = ?1 AND s.updatedAt = ?2", Schedule.class)
                .setParameter(1, getListDto.getUserName())
                .setParameter(2, getListDto.getUpdatedAt())
                .getResultList();

        //3. 엔티티 매니저 정리
        entityManager.close();

        // 4. 반환
        return scheduleList;
    }


    /**
     * 일정 단건 조회
     * @param id
     * @return
     */
    @Override
    public Schedule findById(Long id) {
        //1. 엔티티 매니저 준비
        EntityManager entityManger = emf.createEntityManager();

        //2. 조회
        Schedule foundOne = entityManger.find(Schedule.class, id);

        //3. 엔티티매니저 반환
        entityManger.close();


         return foundOne;
    }


    /**
     * 수정
     * @param updateDto
     */
    @Override
    public ResponseDto updateSchedule(Long id, UpdateScheduleDto updateDto) {
        //1. 엔티티 매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        //2. 트랜잭션 준비
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //3. 수정 로직
        Schedule foundSchedule = entityManager.find(Schedule.class, id);

        foundSchedule.changeTitles(updateDto.getTitles());
        foundSchedule.changeContents(updateDto.getContents());
//        foundSchedule.changeUpdatedAt(LocalDateTime.now());

        //4. 트랜잭션 끝
        transaction.commit();

       Schedule updatedSchedule = entityManager.find(Schedule.class, id);

        //5. 엔티티매니저 정리
        entityManager.close();

        ResponseDto responseDto = new ResponseDto(updatedSchedule);
        return responseDto;
    }


    /**
     * 삭제
     * @param id
     */

    @Override
    public void deleteOne(Long id) {
        //1. 엔티티매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        //2. 트랙잭션 준비
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Schedule toDelete = findById(id);

        //3. 삭제
        entityManager.remove(toDelete);

        //4. 트랜잭션 끝
        transaction.commit();

        //5. 엔티티 매니저 정리
        entityManager.close();
    }

}
