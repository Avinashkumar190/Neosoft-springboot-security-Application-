package com.neosoft.lara;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.neosoft.lara.entity.UserPerson;
import com.neosoft.lara.springsecurity.api.repository.UserpersonRepository;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
//@EnableJpaRepositories
@EnableJpaAuditing
@EnableWebSecurity
public class ProjectStudentAppApplication {
	
	
	 @Autowired
	 private UserpersonRepository repository;

	 @PostConstruct
	public void initUsers() {
		List<UserPerson> users = Stream.of(
                new UserPerson(101, "javatechie", "password", "javatechie@gmail.com"),
                new UserPerson(102, "user1", "pwd1", "user1@gmail.com"),
                new UserPerson(103, "user2", "pwd2", "user2@gmail.com"),
                new UserPerson(104, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectStudentAppApplication.class, args);
	}

}
