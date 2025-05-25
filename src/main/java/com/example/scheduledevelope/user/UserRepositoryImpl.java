package com.example.scheduledevelope.user;

import com.example.scheduledevelope.userDto.UserRequestDto;
import com.example.scheduledevelope.userDto.UserResponseDto;
import com.example.scheduledevelope.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepostioryCustom {
    private final EntityManagerFactory emf;

    //생성자


    public UserRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }


    //기능

    /**
     * 유저 생성
     */
    public UserResponseDto createUser(User user){
        //1. 엔티티 매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        //2. 트랜잭션 준비
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //3. 저장
        entityManager.persist(user);

        //트랜잭션 커밋
        transaction.commit();

        //4. 엔티티매니저 정리
        entityManager.close();

        UserResponseDto userResponseDto = new UserResponseDto(user);
        return userResponseDto;
    }

    public List<User> findAll(){
        //1. 엔티티 매니저 정리
        EntityManager entityManager = emf.createEntityManager();

        //2조회 JPQL
        List<User> userList = entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();

        //3. 엔티티 매니저 정리
        entityManager.close();

        //4. 반환
        return userList;
    };

    public User findOne(Long id) {
        //1. 엔티티 매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        //2. 조회
        User foundOne = entityManager.find(User.class, id);

        //3. 엔티티 매니저 반환
        entityManager.close();

        return foundOne;
    }

    /**
     * 수정
     */
    public UserResponseDto updateAccount(Long id, UserRequestDto userDto){
        //1. 엔티티매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        //2. 트랜잭션 준비
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 3. 수정 로직
        User foundUser = entityManager.find(User.class, id);

        foundUser.changeName(userDto.getUserName());
        foundUser.changeEmail(userDto.getEmail());

        //4.트랜잭션 끝
        transaction.commit();

        User updatedUser = entityManager.find(User.class, id);

        // 5. 엔티티매니저 정리
        entityManager.close();

        UserResponseDto userResponseDto = new UserResponseDto(updatedUser);
        return userResponseDto;
    }

    public void deleteUser(Long id){
        //1. 엔티티 매니저 호출
        EntityManager entityManager = emf.createEntityManager();

        //2. 트랜잭션 준비
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        //3. 삭제할 객체 조회
        User toDelete = entityManager.find(User.class, id);

        //4. 삭제
        entityManager.remove(toDelete);

        //5. 엔티티 매니저 정리
        entityManager.close();
    }
}
