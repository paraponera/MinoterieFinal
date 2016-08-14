package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.minoterie.projet.domain.Spark;

/**
 * Session Bean implementation class SparkDao
 */
@Stateless
@LocalBean
public class SparkDao implements  SparkDaoLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
    public SparkDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void inserer_modifierSpark(Spark spark) {
		// TODO Auto-generated method stub
	   entityManager.persist(spark);	
	}

	@Override
	public void deleteSpark(Spark spark) {
		// TODO Auto-generated method stub
	   entityManager.remove(spark);	
	}

	@Override
	public Spark getById(int Id_spark) {
		// TODO Auto-generated method stub
		return entityManager.find(Spark.class, Id_spark);
	}

	@Override
	public List<Spark> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Spark sp",Spark.class).getResultList();
	}



}
