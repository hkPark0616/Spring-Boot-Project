package com.project.portfolio.domain.repository;

import com.project.portfolio.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findUserEntityById(String id);
    List<UserEntity> findUserEntityByName(String name);

    UserEntity findUserEntityByIdAndPassword(String id, String password);

    Optional<UserEntity> findById(String id);
}

