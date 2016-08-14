package com.minoterie.projet.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.minoterie.projet.domain.StockProduitsFinis;

/**
 * Session Bean implementation class StockProdFiniDao
 */
@Stateless
@LocalBean
public class StockProdFiniDao implements  StockProdFiniDaoLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
    public StockProdFiniDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void inserer_modifierStockF(StockProduitsFinis stockF) {
		// TODO Auto-generated method stub
		entityManager.persist(stockF);
	}

	@Override
	public void deleteStockF(StockProduitsFinis stockF) {
		// TODO Auto-generated method stub
		entityManager.remove(stockF);
	}

	@Override
	public StockProduitsFinis getById(int Id_stockF) {
		// TODO Auto-generated method stub
		return entityManager.find(StockProduitsFinis.class, Id_stockF);
	}

	@Override
	public List<StockProduitsFinis> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from StockProduitsFinis spf",StockProduitsFinis.class).getResultList();
	}

	@Override
	public double getMaxProdFini() {
		double max =0 ;
		List<StockProduitsFinis> p = getAll();
		ArrayList<Double> p1 = new ArrayList<Double>();
		for (StockProduitsFinis produitsFinis : p) {
			p1.add(produitsFinis.getFarine() + produitsFinis.getSemoule());
		}
		max = Collections.max(p1);
		return max;
	}

}
