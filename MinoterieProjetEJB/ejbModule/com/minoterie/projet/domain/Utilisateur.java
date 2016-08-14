package com.minoterie.projet.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Utilisateur
 *
 */
@Entity
@Table (name="utilisateur")
public class Utilisateur implements Serializable {

	

	private String firstName;
	private String lastName;
	private String login;
	private String mdp;
	private String role;
	private int blocked;
	private int loginAttempts;
	private String email;
	private static final long serialVersionUID = 1L;

	public Utilisateur() {
		super();
	} 
 
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	
	@Id
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}   
	public int getBlocked() {
		return this.blocked;
	}

	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}   
	public int getLoginAttempts() {
		return this.loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Utilisateur [firstName=" + firstName + ", lastName=" + lastName + ", login=" + login + ", mdp=" + mdp
				+ ", role=" + role + ", blocked=" + blocked + ", loginAttempts=" + loginAttempts + ", email=" + email
				+ "]";
	}
   
	
}
