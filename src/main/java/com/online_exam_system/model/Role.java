package com.online_exam_system.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@Column(name = "role_Id")
	private Long roleid;
	@Column(name = "role_Name")
	private String rolename;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	private Set<UserRole> userroles = new HashSet<>();
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<UserRole> getUserroles() {
		return userroles;
	}

	public void setUserroles(Set<UserRole> userroles) {
		this.userroles = userroles;
	}
	

}
