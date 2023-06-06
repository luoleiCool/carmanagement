package com.luol.carmanagement.repository;

import com.luol.carmanagement.entity.AreaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaUserRepository extends JpaRepository<AreaUser, Integer> {
}
