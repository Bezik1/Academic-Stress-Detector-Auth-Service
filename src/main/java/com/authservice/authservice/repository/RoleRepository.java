package com.authservice.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authservice.authservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{}
