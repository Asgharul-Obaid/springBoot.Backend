package com.springboot.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.springboot.springboot.regex.RegexConstant;

import lombok.Data;



@Entity
@Table(name="employees")
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "First Name is required & ALPHABETS ONLY !")
	@Pattern(regexp = RegexConstant.ALPHABETS_ONLY, message = "use ALPHABETS ONLY")
	@Column(name="first_Name",nullable=false)
	private String firstName;
	
	@NotBlank(message = "First Name is required & ALPHABETS ONLY !")
	@Pattern(regexp = RegexConstant.ALPHABETS_ONLY, message = "use ALPHABETS ONLY")
	@Column(name="last_Name")
	private String lastName;
	
	@Pattern(regexp = RegexConstant.EMAIL, message = "Mail Should be Proper !")
	@Column(name="email")
	private String email;

	
	
}
