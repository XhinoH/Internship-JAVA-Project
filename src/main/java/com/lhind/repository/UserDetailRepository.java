package com.lhind.repository;

import com.lhind.model.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

    public Optional<UserDetail> findByUserId(Integer id);
}
