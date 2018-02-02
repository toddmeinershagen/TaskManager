package com.ansh.test.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department implements Serializable {
	
	@Id
    @GeneratedValue
    @Column(name="dept_id")
	private Integer id;
	
	public Department() {
		super();
	}

	public Department(Integer id, String deptName) {
		super();
		this.id = id;
		this.deptName = deptName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name="deptName")
	private String deptName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

}
