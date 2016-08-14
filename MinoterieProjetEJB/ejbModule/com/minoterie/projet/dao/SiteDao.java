package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.minoterie.projet.domain.Site;

/**
 * Session Bean implementation class SiteDao
 */
@Stateless
@LocalBean
public class SiteDao implements  SiteDaoLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
	
    public SiteDao() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public void inserer_modifierSite(Site ste) {
		// TODO Auto-generated method stub
		entityManager.persist(ste);
	}


	@Override
	public void deleteSite(Site ste) {
		// TODO Auto-generated method stub
		entityManager.remove(ste);
	}


	@Override
	public Site getById(int Id_STE) {
		// TODO Auto-generated method stub
		return entityManager.find(Site.class, Id_STE);
	}


	@Override
	public List<Site> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select s from Site s", Site.class).getResultList();
	}

}
