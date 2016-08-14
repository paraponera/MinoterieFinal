package com.minoterie.projet.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.minoterie.projet.domain.Production;

/**
 * Session Bean implementation class ProductionDao
 */
@Stateless
@LocalBean
public class ProductionDao implements ProductionDaoLocal {

    /**
     * Default constructor. 
     */
	
	
	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
	
    public ProductionDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addProduction(Production production) {
		entityManager.persist(production);
		
	}

	@Override
	public Production getProductionbyday() {
      List<Production> productions = entityManager.createQuery("select r from Production r", Production.class).getResultList();
     return  productions.get(productions.size() - 1);
	}

	@Override
	public List<Production> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select r from Production r", Production.class).getResultList();
	}

	@Override
	public List<Production> getProductoinbyWeek() {
		Date d = new Date();//intialize your date to any date 
		Date dateBefore = new Date(d.getTime() - 7 * 24 * 3600 * 1000l );
		return entityManager.createQuery("select r from Production r where r.date between :day1 and current_date()   ", Production.class).setParameter(":day1", dateBefore).getResultList();
	}

	@Override
	public List<Production> getPoductionbyMonth() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select r from Production r where month(r.date)= month(current_date())", Production.class).getResultList();
	}

}
