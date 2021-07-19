package com.neosoft.lara.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.lara.entity.Student;
@Repository
public interface StudentRepositry extends JpaRepository<Student, Integer> {

}
