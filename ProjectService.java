package com.neosoft.lara.service;

import java.util.List;

import com.neosoft.lara.entity.Project;
import com.neosoft.lara.entity.Student;

public interface ProjectService {
	public Project findById(int theProjectId);
	public List<Project> findAll();

}
