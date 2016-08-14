package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.minoterie.projet.domain.Rapport;

/**
 * Session Bean implementation class RapportDao
 */
@Stateless
@LocalBean
public class RapportDao implements  RapportDaoLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
	
    public RapportDao() {
        // TODO Auto-generated constructor stub
    }


    @Override
	public void inserer_modifierRapport(Rapport rapprt) {
	entityManager.merge(rapprt);	
		
	}

	@Override
	public void deleteRapport(Rapport rapprt) {
		entityManager.remove(rapprt);
		
	}

	@Override
	public Rapport getById(int Id_Rpt) {
		return entityManager.find(Rapport.class, Id_Rpt);
	}

	@Override
	public List<Rapport> getAll() {
		return entityManager.createQuery("select r from Rapport r", Rapport.class).getResultList();
	}

}
