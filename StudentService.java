package com.neosoft.lara.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.neosoft.lara.entity.Project;
import com.neosoft.lara.entity.Student;

public interface StudentService {
	
	//public List<Student> FindAll();
	public Student findById(int theId);
	public void save(Student theStudent);
	//public void save(Project theProject);
	//public Page<Student> getAllPosts(Pageable pageable);
	//public void saveProject(Project theProject);

}
