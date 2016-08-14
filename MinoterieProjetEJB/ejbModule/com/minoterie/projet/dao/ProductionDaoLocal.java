package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.Production;

@Local
public interface ProductionDaoLocal {

	public void addProduction(Production production);
	public Production getProductionbyday();
	public List<Production> getAll();
	public List<Production> getProductoinbyWeek();
	public List<Production> getPoductionbyMonth();
}
