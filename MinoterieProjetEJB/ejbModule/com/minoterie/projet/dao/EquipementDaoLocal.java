package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.Equipement;

@Local
public interface EquipementDaoLocal {

	public void inserer_modifierEquipement(Equipement equip);
    public void deleteEquipement(Equipement equip);
    public Equipement getById(int Id_equip);
    public List<Equipement> getAll();

}
