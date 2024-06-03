package com.app.baseone.security.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.baseone.security.domain.entity.UserBasicAuthEntity;

@Repository
public interface IUserBasicAuthRepository  extends JpaRepository<UserBasicAuthEntity, Long> {

    Optional<UserBasicAuthEntity> findByUsername(String username);
}
