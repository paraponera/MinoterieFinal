package com.minoterie.projet.ctrl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;



import com.minoterie.projet.dao.UtilisateurDaoLocal;
import com.minoterie.projet.domain.Utilisateur;



@ManagedBean
@SessionScoped
public class UserCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Utilisateur selectutilisateur ;
	private List<Utilisateur> utilisateurs ;
	private Utilisateur userModif = new Utilisateur() ;

	 
	public UserCtrl() {
		// TODO Auto-generated constructor stub
		
	}
	
	@EJB
	UtilisateurDaoLocal utilisateurDaoLocal;
     
	
	
	@PostConstruct
	public void init(){
	  	utilisateurs = utilisateurDaoLocal.getAllUser();
	}

	 public void ajouter() {
		 try {
			 utilisateurDaoLocal.addUser(userModif);
		} catch (Exception e) {
	        FacesMessage message = null;
	        message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !", "utilisateur existant");
	        FacesContext.getCurrentInstance().addMessage(null, message);

		}
	       

	    }
	 
	 public void onRowEdit(RowEditEvent event) {
	       System.out.println( ((Utilisateur) event.getObject()).toString());
	       utilisateurDaoLocal.updUser(((Utilisateur) event.getObject()));
	    }
	 

	public Utilisateur getSelectutilisateur() {
		return selectutilisateur;
	}

	public void setSelectutilisateur(Utilisateur selectutilisateur) {
		this.selectutilisateur = selectutilisateur;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}


	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur getUserModif() {
		return userModif;
	}

	public void setUserModif(Utilisateur userModif) {
		this.userModif = userModif;
	}


	
	
	
}
