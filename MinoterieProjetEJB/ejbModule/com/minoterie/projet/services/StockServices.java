package com.minoterie.projet.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.minoterie.projet.domain.StockMatierePremiere;
import com.minoterie.projet.domain.StockProduitsFinis;


/**
 * Session Bean implementation class StockServices
 */
@Stateless
@LocalBean
public class StockServices implements StockServicesLocal {

    /**
     * Default constructor. 
     */
	

	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
	
    public StockServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<StockMatierePremiere> getStockMPbyWeek() {
		// TODO Auto-generated method stub
		Date d = new Date();//intialize your date to any date 
		Date dateBefore = new Date(d.getTime() - 7 * 24 * 3600 * 1000l );
		return entityManager.createQuery("select mp from StockMatierePremiere mp where mp.date between :day1 and  current_date() ",StockMatierePremiere.class).setParameter("day1", dateBefore).getResultList();
	}

	@Override
	public List<StockMatierePremiere> getStockMPbyMonth() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select mp from StockMatierePremiere mp where month(mp.date) = month(current_date()) ",StockMatierePremiere.class).getResultList();
	}

	@Override
	public List<StockMatierePremiere> getStockMPbyYear() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select mp from StockMatierePremiere mp where year(mp.date) = year(current_date()) ",StockMatierePremiere.class).getResultList();
	}

	@Override
	public List<StockProduitsFinis> getStockProdFinibyWeek() {
		Date d = new Date();//intialize your date to any date 
		Date dateBefore = new Date(d.getTime() - 7 * 24 * 3600 * 1000l );
		return entityManager.createQuery("select mp from StockProduitsFinis mp where mp.date between :day1 and  current_date() ",StockProduitsFinis.class).setParameter("day1", dateBefore).getResultList();
	}

	@Override
	public List<StockProduitsFinis> getStockProdFinibyMonth() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select mp from StockProduitsFinis mp where month(mp.date) = month(current_date()) ",StockProduitsFinis.class).getResultList();
	}

	@Override
	public List<StockProduitsFinis> getStockProdFinibyYear() {
		return entityManager.createQuery("select mp from StockProduitsFinis mp where year(mp.date) = year(current_date()) ",StockProduitsFinis.class).getResultList();
	}



	@Override
	public List<StockMatierePremiere> getStockMPbyday() {
		return entityManager.createQuery("select mp from StockMatierePremiere mp where mp.date = current_date() ",StockMatierePremiere.class).getResultList();
	}

	@Override
	public List<StockProduitsFinis> getStockProdFinibyDay() {
		return entityManager.createQuery("select mp from StockProduitsFinis mp where mp.date = current_date() ",StockProduitsFinis.class).getResultList();
	}

}
