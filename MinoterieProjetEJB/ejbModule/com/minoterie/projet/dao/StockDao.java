package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.minoterie.projet.domain.Stock;

/**
 * Session Bean implementation class StockDao
 */
@Stateless
@LocalBean
public class StockDao implements StockDaoLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
    public StockDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void inserer_modifierSpark(Stock spark) {
		entityManager.persist(spark);
		
	}

	@Override
	public Stock getbydate() {
		List<Stock> list =  entityManager.createQuery("from Stock s ", Stock.class).getResultList();
		return 		 list.get(list.size() - 1);

	}

	@Override
	public List<Stock> getAll() {
		
		return entityManager.createQuery("from Stock s", Stock.class).getResultList();
	}

}
