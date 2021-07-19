package com.neosoft.lara.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="projid")
	private int projid;

	@NotNull
	@Column(name="proj_name")
	private String projname;

	@NotNull
	@Column(name="proj_duration")
	private String duration;

	//@Column(name="list_students")
	//private List<Student> students;


	/*
	 * @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
	 * CascadeType.DETACH, CascadeType.REFRESH})
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@ManyToOne(cascade = CascadeType.ALL)
	//@OneToOne(cascade = CascadeType.ALL)//nullable = false
	@JoinColumn(name="student_details_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Student studentDetails;


}
