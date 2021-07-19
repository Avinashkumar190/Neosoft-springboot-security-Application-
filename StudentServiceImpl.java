package com.neosoft.lara.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neosoft.lara.Dao.ProjectReposity;
//import com.neosoft.lara.Dao.StudentDAO;
import com.neosoft.lara.Dao.StudentRepositry;
import com.neosoft.lara.entity.Project;
import com.neosoft.lara.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepositry studentDAO; 
	
	@Autowired
	private ProjectReposity projectRepo;
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		studentDAO.save(theStudent);
	}
	
	@Override
	@Transactional
	public Student findById(int theId) {
		Optional<Student> result = studentDAO.findById(theId);
		Student theStudent = null;
		if(result.isPresent()) {
			theStudent = result.get();
		}else {
			throw new RuntimeException("Did not find Student Id-" + theId);
		}
		return theStudent;
	}
	
}
