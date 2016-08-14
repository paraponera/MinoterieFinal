package com.minoterie.projet.dao;


import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.TransactionTimeout;


import com.minoterie.projet.domain.Point;

/**
 * Session Bean implementation class PointDao
 */
@Stateless
@LocalBean
public class PointDao implements PointDaoLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
    public PointDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void inserer_modifierPoint(Point pnt) {
		// TODO Auto-generated method stub
		entityManager.persist(pnt);
	}

	@Override
	public void deletePoint(Point pnt) {
		// TODO Auto-generated method stub
		entityManager.remove(pnt);
	}

	@Override
	public Point getById(int Id_pnt) {
		// TODO Auto-generated method stub
		return entityManager.find(Point.class, Id_pnt);
	}
	@SuppressWarnings("unchecked")

	@Override
	public List<Point> getAll() {
		
		return entityManager.createQuery("from Point p").getResultList();
	}
	@TransactionTimeout(1500)
	@Override
	public Point GetPointByName(String nom) {
		
		Point p = new Point();
		List<Point> points = getAll();
		for (int i=0; i< points.size(); i++) {
		 	if (points.get(i).getNom().equals(nom)) {
				p=points.get(i);
			
		} 
		}
		return p ;
	}

}
