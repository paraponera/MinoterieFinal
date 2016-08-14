package com.minoterie.projet.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.minoterie.projet.domain.Point;

/**
 * Session Bean implementation class StatistiqueService
 */
@Stateless
@LocalBean
public class StatistiqueService implements StatistiqueServiceLocal {

    /**
     * Default constructor. 
     */
	
	
	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
	
	
    public StatistiqueService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Point> getPuissancebyWeek() {
		Date d = new Date();//intialize your date to any date 
		Date dateBefore = new Date(d.getTime() - 7 * 24 * 3600 * 1000l );
		return  entityManager.createQuery("from Point p where p.nom='puissance' and p.date between :day1 and  current_date()", Point.class).setParameter("day1", dateBefore).getResultList();
	}

	@Override
	public List<Point> getStockPuissancebyMonth() {
		// TODO Auto-generated method stub
		return  entityManager.createQuery("from Point p where p.nom='puissance' and month(p.date) = month(current_date())", Point.class).getResultList();
	}

	@Override
	public List<Point> getStockPuissancebyYear() {
		// TODO Auto-generated method stub
		return  entityManager.createQuery("from Point p where p.nom='puissance' and year(p.date) = year(current_date())", Point.class).getResultList();

	}

	@Override
	public List<Point> getStockCourantbyWeek() {
		Date d = new Date();//intialize your date to any date 
		Date dateBefore = new Date(d.getTime() - 7 * 24 * 3600 * 1000l );
		return  entityManager.createQuery("from Point p where p.nom='courant' and p.date between :day1 and  current_date()", Point.class).setParameter("day1", dateBefore).getResultList();
	}

	@Override
	public List<Point> getStockCourantbyMonth() {
		// TODO Auto-generated method stub
		return  entityManager.createQuery("from Point p where p.nom='courant' and month(p.date) = month(current_date())", Point.class).getResultList();
	}

	@Override
	public List<Point> getStockCourantbyYear() {
		// TODO Auto-generated method stub
		return   entityManager.createQuery("from Point p where p.nom='courant' and year(p.date) = year(current_date())", Point.class).getResultList();

	}

	@Override
	public List<Point> getStockCosphibyWeek() {
		Date d = new Date();//intialize your date to any date 
		Date dateBefore = new Date(d.getTime() - 7 * 24 * 3600 * 1000l );
		return  entityManager.createQuery("from Point p where p.nom='cosphi' and p.date between day(:day1) and  day(current_date())", Point.class).setParameter("day1", dateBefore).getResultList();
	}

	@Override
	public List<Point> getStockCosphibyMonth() {
		// TODO Auto-generated method stub
		return  entityManager.createQuery("from Point p where p.nom='cosphi' and month(p.date) = month(current_date())", Point.class).getResultList();

	}

	@Override
	public List<Point> getStockCosphibyYear() {
		// TODO Auto-generated method stub
		return   entityManager.createQuery("from Point p where p.nom='cosphi' and year(p.date) = year(current_date())", Point.class).getResultList();
	}

	@Override
	public List<Point> getPuissaceByDay() {
		// TODO Auto-generated method stub
		return   entityManager.createQuery("from Point p where p.nom='puissance' and day(p.date)= day(current_date())", Point.class).getResultList();

	}

	@Override
	public List<Point> getCourantByDay() {
		// TODO Auto-generated method stub
		return   entityManager.createQuery("from Point p where p.nom='courant' and day(p.date) = day(current_date())", Point.class).getResultList();

	}

	@Override
	public List<Point> getCosphiByDay() {
		// TODO Auto-generated method stub
		return   entityManager.createQuery("from Point p where p.nom='cosphi' and day(p.date) = day(current_date())", Point.class).getResultList();

	}

}
