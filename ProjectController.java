package com.neosoft.lara.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.lara.Dao.ProjectReposity;
import com.neosoft.lara.Dao.StudentRepositry;
import com.neosoft.lara.entity.Project;
import com.neosoft.lara.entity.Student;
//import com.example.jpa.exception.ResourceNotFoundException;
import com.neosoft.lara.exception.ResourceNotFoundException;
import com.neosoft.lara.service.ProjectService;

@RestController
@RequestMapping("/noauth/rest")
public class ProjectController {

	@Autowired
	private ProjectReposity projectRepositry;

	@Autowired
	private StudentRepositry studentRepositry;

	@Autowired
	private ProjectService projectService;

	@PostMapping("/students/{studentId}/projects")
	public Project createComment(@PathVariable (value = "studentId") Integer studentId,
			@Valid @RequestBody Project theProject) {
		return studentRepositry.findById(studentId).map(studentDetails -> {
			theProject.setStudentDetails(studentDetails);
			return projectRepositry.save(theProject);
		}).orElseThrow(
				() -> new ResourceNotFoundException("StudentId " + studentId + " not found"));
	}

	@GetMapping("/project/{projectId}")
	public Project findById( @PathVariable int  projectId) {
		Project theProject = projectService.findById(projectId);
		/*
		 * if(theStudent == null) { throw new
		 * RuntimeException("project id not found===:" + projectId); }
		 */
		return theProject;
	}

	@GetMapping("/students/{id}/projects") 
	public List<Project> getAllCommentsByPostId(@PathVariable (value = "id") Integer id) {
		ArrayList<Integer>  list = new ArrayList<>();
		list.add(id);
		return  null;//projectRepositry.findAllByStudentIdIn(list);
	}
	
	@GetMapping("project")
	List<Project> findAll(){
		return projectService.findAll();
	}
	
	@GetMapping("/")
	public String showProject() {
		return "welcome project";
	}
	
	@GetMapping("/process")
	public String process() {
		return "processing...";
	}

}
