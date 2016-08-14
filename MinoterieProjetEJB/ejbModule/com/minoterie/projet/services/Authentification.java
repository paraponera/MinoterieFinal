package com.minoterie.projet.services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.minoterie.exception.NotAutorizedException;
import com.minoterie.projet.dao.UtilisateurDaoLocal;
import com.minoterie.projet.domain.Utilisateur;

/**
 * Session Bean implementation class Authentification
 */
@Stateless
@LocalBean
public class Authentification implements AuthentificationLocal {

    /**
     * Default constructor. 
     */
	
	@EJB
	UtilisateurDaoLocal utilisateurDaoLocal ;
	
    public Authentification() {
        // TODO Auto-generated constructor stub
    	
    }

	@Override
	public String authenficate(Utilisateur users) throws NotAutorizedException {
		// TODO Auto-generated method stub
		 Utilisateur usersToFind =utilisateurDaoLocal.findUser(users.getLogin());
	        if (usersToFind== null) throw new NotAutorizedException();
			if (!(usersToFind.getMdp().equals(users.getMdp()))) throw new NotAutorizedException() ;
		    return usersToFind.getRole();
	}

}
