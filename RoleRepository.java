package com.neosoft.lara.springsecurity.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.lara.springsecurity.api.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
