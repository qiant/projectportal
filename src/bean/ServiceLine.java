package com.jwt.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="serviceLine")
public class ServiceLine implements Serializable{
	private int id;
	private String name;
	
	public ServiceLine(){}
	public ServiceLine(String name){
		
		this.name=name;
	}
	
	@Id
	@GeneratedValue @Column
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@NotNull@NotEmpty
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
