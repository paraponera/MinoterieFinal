package com.minoterie.projet.ctrl;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.minoterie.exception.NotAutorizedException;
import com.minoterie.projet.domain.Utilisateur;
import com.minoterie.projet.services.*;

@ManagedBean
@SessionScoped
public class LoginCtrl  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	AuthentificationLocal authentificationLocal;

	public Utilisateur users = new Utilisateur();
	public boolean loggedIn = false;
    public String log = null;
	public String doLogin() {
		try {
			log=users.getLogin();
			String role = authentificationLocal.authenficate(users);
			if (role.equals("admin")) {
				loggedIn=true;
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("admin.jsf");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (role.equals("user")) {
				loggedIn=true;
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("user.jsf");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} catch (NotAutorizedException e) {
	        FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Authenfication Erreur", "Login/password Inccorect"));  
			return "error";
		}
		loggedIn=true;
		return "admin";
	}

	public String doLogout() {
		// Set the paremeter indicating that user is logged in to false
		loggedIn = false;
		
		HttpSession session =  (HttpSession) FacesContext.getCurrentInstance()
		.getExternalContext().getSession(false);
		// Set logout message
		session.invalidate();
		FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return "/index.jsf?faces-redirect=true";
}
	

	public Utilisateur getUsers() {
		return users;
	}





	public void setUsers(Utilisateur users) {
		this.users = users;
	}





	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
