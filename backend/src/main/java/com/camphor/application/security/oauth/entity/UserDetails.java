package com.camphor.application.security.oauth.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERDETAILS")
public class UserDetails implements Serializable {

	@Id
	@Column(name = "USR_ID")
	private String userId;

	@Column(name = "USR_FNAME")
	private String firstName;

	@Column(name = "USR_LNAME")
	private String lastName;

	@Column(name = "USR_PASSWORD")
	private String password;

	public UserDetails() {
	}

	public UserDetails(String userId, String firstName, String lastName, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
