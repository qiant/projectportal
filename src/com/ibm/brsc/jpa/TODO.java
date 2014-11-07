package com.ibm.brsc.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "todolist")
@Table(name = "todolist")
/*
 * define O-R mapping of todolist table
 */
public class TODO {
	@Id //primary key
	@Column(name = "L_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@Basic
	@Column(name = "C_NAME")
	String name;

	@Basic 
	@Column(name="C_Service_Line")
	String serviceLine;
	
	public String getServiceLine(){
		return serviceLine;
	}
	
	public void setServiceLine(String serviceLine){
		this.serviceLine = serviceLine;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long pk) {
		id = pk;
	}

	@Override
	public String toString() {
		return String.format("{\"id\": \"%d\", \"name\": \"%s\", \"serviceLine \": \"%s\"}", id, name, serviceLine);
	}
}
