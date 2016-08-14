package com.minoterie.projet.services;

import javax.ejb.Local;

import com.minoterie.exception.NotAutorizedException;
import com.minoterie.projet.domain.Utilisateur;

@Local
public interface AuthentificationLocal {
	
	public String authenficate(Utilisateur users)  throws NotAutorizedException ;

}
