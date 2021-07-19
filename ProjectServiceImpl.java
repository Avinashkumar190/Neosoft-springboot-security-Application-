package com.neosoft.lara.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.lara.Dao.ProjectReposity;
import com.neosoft.lara.entity.Project;
import com.neosoft.lara.entity.Student;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	
	@Autowired
	private ProjectReposity projectRepo;
	
	@Override
	@Transactional
	public Project findById(int projectId) {
		Optional<Project> result = projectRepo.findById(projectId);
		Project theProject = null;
		if(result.isPresent()) {
			theProject = result.get();
		}else {
			throw new RuntimeException("Did not find Project Id-" + projectId);
		}
		return theProject;
	}
	
	@Override
	public List<Project> findAll(){
		return projectRepo.findAll();
	}

}
