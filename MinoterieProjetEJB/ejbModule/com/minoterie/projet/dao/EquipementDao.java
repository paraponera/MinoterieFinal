package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.minoterie.projet.domain.Equipement;

/**
 * Session Bean implementation class EquipementDao
 */
@Stateless
@LocalBean
public class EquipementDao implements EquipementDaoLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="MinoterieProjetEJB")
	EntityManager entityManager ;
	
    public EquipementDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void inserer_modifierEquipement(Equipement equip) {
		// TODO Auto-generated method stub
		entityManager.persist(equip);
		
	}

	@Override
	public void deleteEquipement(Equipement equip) {
		// TODO Auto-generated method stub
		entityManager.remove(equip);
	}

	@Override
	public Equipement getById(int Id_equip) {
		// TODO Auto-generated method stub
		return entityManager.find(Equipement.class, Id_equip);
	}

	@Override
	public List<Equipement> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select e from Equipement e", Equipement.class).getResultList();
	}

}
