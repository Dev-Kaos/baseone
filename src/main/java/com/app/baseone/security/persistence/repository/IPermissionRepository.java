package com.app.baseone.security.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.baseone.security.domain.entity.PermissionEntity;
import com.app.baseone.security.domain.entity.UserBasicAuthEntity;
import com.app.baseone.utilities.enums.StateEnum;

@Repository
public interface IPermissionRepository extends JpaRepository<PermissionEntity, Long> {

    Optional<PermissionEntity> findById(Long id);

    List<PermissionEntity> findByNameContaining(String name);

    @Query("SELECT p FROM PermissionEntity p WHERE p.state = :state")
    List<PermissionEntity> findByState(StateEnum state);

    @Query("SELECT p FROM PermissionEntity p WHERE p.state = :state")
    List<PermissionEntity> findByRole(StateEnum state);

}
