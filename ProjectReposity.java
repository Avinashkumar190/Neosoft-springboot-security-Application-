package com.neosoft.lara.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.neosoft.lara.entity.Project;
import com.neosoft.lara.entity.Student;


//@Qualifier("projectRepositry")
//@Repository
//@EnableJpaRepositories(basePackages = {"com.neosoft.lara.Dao.ProjectReposity"})
//@EnableTransactionManagement
//@EnableSpringDataWebSupport
//@Configuration
@Repository
public interface ProjectReposity extends JpaRepository<Project, Integer> {
	
	//@Autowired
	//@Qualifier("StudentController")
	//Page<Project> findByPostId(Integer id, Pageable pageable);
	
    //Optional<Project> findByIdAndStudentId(Integer postId, Integer projid);
	//List<Project> findById(Integer studentId, Pageable pageable);
    
    
   // Page<Comment> findByPostId(Long postId, Pageable pageable);
    //Optional<Comment> findByIdAndPostId(Long id, Long postId);
	
	// public List<Project> findAllByStudentIdIn(List<Integer> id);

}
