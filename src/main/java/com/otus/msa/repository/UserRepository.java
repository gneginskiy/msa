package com.otus.msa.repository;

import com.otus.msa.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends
        JpaRepository<UserEntity, UUID>, QuerydslPredicateExecutor<UserEntity> {
}
