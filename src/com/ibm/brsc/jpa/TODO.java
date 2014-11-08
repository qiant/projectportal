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
	@Column(name="C_SERVICE_LINE")
	String serviceLine;

	@Basic 
	@Column(name="L_NUM_PLAN_ROLES")
	long numPlanRoles; 
	
	@Basic 
	@Column(name="L_NUM_NON_INTERLOCK")
	long numNonInterlock;
	
	@Basic 
	@Column(name="L_NUM_INTERLOCK")
	long numInterlock;
	
	@Basic 
	@Column(name="C_SKILLS_REQUIRED")
	String skillsRequired;
	
	@Basic
	@Column(name="L_NUM_OF_RESOURCE")
	long numOfResources;
	/*
	<th style='width:8%'>Estimate Start</th>
	<th style='width:8%'>Top 10</th>
	<th style='width:8%'>Odds</th>
	<th style='width:8%'>Contact Info</th>
	<th style='width:8%'>Comments</th>	
	<th style='width:10%'>Action</th></tr></tbody></table>
	*/
	public String getServiceLine(){
		return serviceLine;
	}
	
	public long getNumPlanRoles() {
		return numPlanRoles;
	}

	public void setNumPlanRoles(long numPlanRoles) {
		this.numPlanRoles = numPlanRoles;
	}

	public long getNumNonInterlock() {
		return numNonInterlock;
	}

	public void setNumNonInterlock(long numNonInterlock) {
		this.numNonInterlock = numNonInterlock;
	}

	public long getNumInterlock() {
		return numInterlock;
	}

	public void setNumInterlock(long numInterlock) {
		this.numInterlock = numInterlock;
	}

	public String getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public long getNumOfResources() {
		return numOfResources;
	}

	public void setNumOfResources(long numOfResources) {
		this.numOfResources = numOfResources;
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

	/**
	 * write this in JSON format
	 */
	@Override
	public String toString() {
		return String.format("{\"id\": \"%d\", "
				+ "\"name\": \"%s\", "
				+ "\"serviceLine\": \"%s\", "
				+ "\"numPlanRoles\": \"%d\", " 
				+ "\"numNonInterlock\": \"%d\", " 
				+ "\"numInterlock\": \"%d\", "
				+ "\"skillsRequired\": \"%s\","  
				+ "\"numOfResources\": \"%d\""
				+ "}", 
				id, name, serviceLine,numPlanRoles, numNonInterlock,numInterlock,skillsRequired,numOfResources
			 );
	}
}
