package com.neosoft.lara.springsecurity.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.lara.entity.UserPerson;

public interface UserpersonRepository extends JpaRepository<UserPerson,Integer> {
    UserPerson findByUserName(String username);
}
