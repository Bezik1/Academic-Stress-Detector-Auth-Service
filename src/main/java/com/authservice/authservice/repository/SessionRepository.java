package com.authservice.authservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authservice.authservice.model.Session;


public interface SessionRepository extends JpaRepository<Session, Long>{
    List<Session> findByUserId(Long userId);
}
