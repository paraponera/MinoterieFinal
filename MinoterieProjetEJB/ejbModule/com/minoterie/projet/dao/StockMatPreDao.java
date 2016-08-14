package com.minoterie.projet.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.minoterie.projet.domain.StockMatierePremiere;


/**
 * Session Bean implementation class StockMatPreDao
 */
@Stateless
@LocalBean
public class StockMatPreDao implements  StockMatPreDaoLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
    public StockMatPreDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void inserer_modifierMatPrem(StockMatierePremiere stockm) {
		// TODO Auto-generated method stub
		entityManager.persist(stockm);
	}

	@Override
	public void deletematPrem(StockMatierePremiere stockm) {
		// TODO Auto-generated method stub
		entityManager.remove(stockm);
	}

	@Override
	public StockMatierePremiere getById(int Id_stockm) {
		// TODO Auto-generated method stub
		return entityManager.find(StockMatierePremiere.class, Id_stockm);
	}

	@Override
	public List<StockMatierePremiere> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from StockMatierePremiere smp ",StockMatierePremiere.class).getResultList();
	}

	@Override
	public double getMaxMP() {
		double max =0 ;
		List<StockMatierePremiere> p = getAll();
		ArrayList<Double> p1 = new ArrayList<Double>();
		for (StockMatierePremiere produitsFinis : p) {
			p1.add(produitsFinis.getBle());
		}
		max = Collections.max(p1);
		return max;
	}

}
