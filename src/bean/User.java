package com.jwt.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sysuser")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8091672638344540763L;
	private int id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String city;

	public User() {

	}

	public User(String username, String password, String email, String phone,
			String city) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.city = city;
	}

	@Id
	@GeneratedValue
	@Column
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
