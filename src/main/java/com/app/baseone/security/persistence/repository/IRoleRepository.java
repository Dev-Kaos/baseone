package com.app.baseone.security.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.baseone.security.domain.entity.RoleEntity;
import com.app.baseone.security.domain.entity.UserBasicAuthEntity;
import com.app.baseone.utilities.enums.RoleEnum;
import com.app.baseone.utilities.enums.StateEnum;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long>{


    Optional<RoleEntity> findById(Long id);

    @Query("SELECT p FROM RoleEntity p WHERE p.name = :role")
    List<RoleEntity> findByNameContaining(RoleEnum role);

    @Query("SELECT p FROM RoleEntity p WHERE p.state = :state")
    List<RoleEntity> findByState(StateEnum state);

}
