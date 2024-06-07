package com.app.baseone.users.persistence.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.baseone.security.domain.entity.UserBasicAuthEntity;
import com.app.baseone.users.domain.entity.UserEntity;
import com.app.baseone.utilities.enums.DocTypeEnum;
import com.app.baseone.utilities.enums.GenderEnum;
import com.app.baseone.utilities.enums.StateEnum;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
    
    Optional<UserEntity> findById(Long id);

    List<UserEntity> findByNameContaining(String name);

    List<UserEntity> findBySurnameContaining(String surname);

    List<UserEntity> findByDocType(DocTypeEnum docType);

    List<UserEntity> findByDocNumberContaining(String docNumber);

    List<UserEntity> findByBirthDate(LocalDate birthDate);

    List<UserEntity> findByEmailContaining(String email);

    List<UserEntity> findByPhoneContaining(String phone);

    List<UserEntity> findByGender(GenderEnum gender);

    List<UserEntity> findByProfileImage(String profileImage);

    List<UserEntity> findByNicknameContaining(String nickname);

    @Query("SELECT p FROM UserEntity p WHERE p.state = :state")
    List<UserEntity> findByState(StateEnum state);
}
