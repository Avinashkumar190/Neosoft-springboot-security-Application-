package com.neosoft.lara.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERPERSON_TBL")
public class UserPerson {
	@Id
    private int id;
    private String userName;
    private String password;
    private String email;

}
