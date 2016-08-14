package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.minoterie.projet.domain.Utilisateur;

/**
 * Session Bean implementation class UtilisateurDao
 */
@Stateless
@LocalBean
public class UtilisateurDao implements  UtilisateurDaoLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
    public UtilisateurDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addUser(Utilisateur users) {
		// TODO Auto-generated method stub
		entityManager.persist(users);
	}

	@Override
	public void updUser(Utilisateur user) {
		// TODO Auto-generated method stub
		entityManager.merge(user);
	}

	@Override
	public Utilisateur findUser(String idUser) {
		// TODO Auto-generated method stub
	   return entityManager.find(Utilisateur.class, idUser);
	}

	@Override
	public void delUser(Utilisateur user) {
		// TODO Auto-generated method stub
		entityManager.remove(findUser(user.getLogin()));
	}

	@Override
	public List<Utilisateur> getAllUser() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Utilisateur u", Utilisateur.class).getResultList();
	}

}
