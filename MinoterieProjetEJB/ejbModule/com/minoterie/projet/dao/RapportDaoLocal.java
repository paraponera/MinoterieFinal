package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.Rapport;

@Local
public interface RapportDaoLocal {
	


	public void inserer_modifierRapport(Rapport rapprt);
    public void deleteRapport(Rapport rapprt);
    public Rapport getById(int Id_Rpt);
    public List<Rapport> getAll();


}
