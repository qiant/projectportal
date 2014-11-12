package com.jwt.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client  implements Serializable {
	
	private int id;
	private String clientName;
	private String year;
	private String quarter;
	private String odds;
	private Integer staffNumber;
	private Integer nonInterlockNumber;
	private Integer interlockNumber;
	private Integer resourceNumber;
	private String contactInfo;
	private String comments;
	private String status;
	private ServiceLine serviceLine;
	private Set<Skill> skills = 
			new HashSet<Skill>(0);
	
	
	public Client(){
		
	}
	
	public Client(String clientName, String year, 
            String quarter, String odds,Integer staffNumber,Integer nonInterlockNumber,Integer interlockNumber,Integer resourceNumber,String contactInfo,String comments,String status,ServiceLine serviceLine,Set<Skill> skills) {
		this.clientName = clientName; 
		this.year = year; 
		this.quarter = quarter; 
		this.odds = odds;
		this.staffNumber = staffNumber; 
		this.nonInterlockNumber = nonInterlockNumber; 
		this.interlockNumber = interlockNumber; 
		this.resourceNumber = resourceNumber;
		this.contactInfo = contactInfo; 
		this.comments = comments; 
		this.status = status; 
		this.serviceLine = serviceLine;
		this.skills=skills;
}
	@Id
	@GeneratedValue @Column
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	@Column
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Column
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	@Column
	public String getOdds() {
		return odds;
	}
	public void setOdds(String odds) {
		this.odds = odds;
	}
	@Column
	public Integer getStaffNumber() {
		return staffNumber;
	}
	public void setStaffNumber(Integer staffNumber) {
		this.staffNumber = staffNumber;
	}
	@Column
	public Integer getNonInterlockNumber() {
		return nonInterlockNumber;
	}
	public void setNonInterlockNumber(Integer nonInterlockNumber) {
		this.nonInterlockNumber = nonInterlockNumber;
	}
	@Column
	public Integer getInterlockNumber() {
		return interlockNumber;
	}
	public void setInterlockNumber(Integer interlockNumber) {
		this.interlockNumber = interlockNumber;
	}
	@Column
	public Integer getResourceNumber() {
		return resourceNumber;
	}
	public void setResourceNumber(Integer resourceNumber) {
		this.resourceNumber = resourceNumber;
	}
	@Column
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	@Column
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Column
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "serviceLine_id")
	public ServiceLine getServiceLine() {
		return serviceLine;
	}
	public void setServiceLine(ServiceLine serviceLine) {
		this.serviceLine = serviceLine;
	}
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "client_skill", catalog = "jwt", joinColumns = { 
			@JoinColumn(name = "CLIENT_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "SKILL_ID", 
					nullable = false, updatable = false) })
	public Set<Skill> getSkills() {
		return skills;
	}
	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
	
	
	
	
}
