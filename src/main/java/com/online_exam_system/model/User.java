package com.online_exam_system.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "user_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "FullName",nullable = false)
	private String fullname;
	@Column(name = "UserName",nullable = false)
	private String username;
	@Column(name = "PassWord",nullable = false)
	private String password;
	@Column(name = "MobileNo",nullable = false)
	private String mobileno;
	@Column(name = "City",nullable = false)
	private String city;
	@Column(name = "user_DOB",nullable = false)
	private String dob;
	@Column(name = "State",nullable = false)
	private String state;
	@Column(name = "Qualification")
	private String qualification;
	@Column(name = "YearOFCompletion")
	private String year;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userroles = new HashSet<>();
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public User(Long id, String fullname, String username, String password, String mobileno, String city, String dob,
			String state, String qualification, String year) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
		this.city = city;
		this.dob = dob;
		this.state = state;
		this.qualification = qualification;
		this.year = year;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Set<UserRole> getUserroles() {
		return userroles;
	}

	public void setUserroles(Set<UserRole> userroles) {
		this.userroles = userroles;
	}



	public String getQualification() {
		return qualification;
	}



	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
}
