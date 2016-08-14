package com.minoterie.projet.services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.TransactionTimeout;

import com.minoterie.projet.dao.PointDaoLocal;
import com.minoterie.projet.domain.Point;

/**
 * Session Bean implementation class PowerService
 */
@Stateless
@LocalBean
public class PowerService implements PowerServiceLocal {

    /**
     * Default constructor. 
     */
    public PowerService() {
        // TODO Auto-generated constructor stub
    }

    @EJB
    PointDaoLocal  pointdaolocal ;
    @TransactionTimeout(1500)
	@Override
	public Point getPuissance() {
		// TODO Auto-generated method stub
		 return pointdaolocal.GetPointByName("puissance");
	}

	@Override
	public Point getCourrant() {
		// TODO Auto-generated method stub
		return pointdaolocal.GetPointByName("courant");
	}

	@Override
	public Point getCosphi() {
		// TODO Auto-generated method stub
		return pointdaolocal.GetPointByName("cosphi");
	}


    


}
