package com.neosoft.lara.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@NotNull
    @Size(max = 100)
	@Column(name="first_name")
	private String firstName;

	@NotNull
    @Size(max = 100)
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
    @Size(max = 100)
	@Column(name="email_address")
	private String emailAddress;

	@NotNull
    @Size(max = 100)
	@Column(name="mobile_numbre")
	private String mobileNumber;

	@NotNull
    @Size(max = 100)
	@Column(name="photo_upload")
	private String photoUpload;


	/*
	 * @OneToMany(mappedBy = "studentDetails", cascade = {CascadeType.PERSIST,
	 * CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	 * 
	 * //@OneToMany(mappedBy = "studentDetails", cascade = CascadeType.ALL)
	 * //@OneToOne(mappedBy = "studentDetails", cascade = CascadeType.ALL) //private
	 * Project projectDetails; private List<Project> projectDetails;
	 * 
	 * //@Column(name="project_list") //private List<Project> projects;
	 * 
	 * //add convenience method for bi-directionl relationship public void
	 * add(Project theproject) { if(projectDetails == null) { projectDetails = new
	 * ArrayList<>(); } projectDetails.add(theproject);
	 * theproject.setStudentDetails(this); }
	 */

}
