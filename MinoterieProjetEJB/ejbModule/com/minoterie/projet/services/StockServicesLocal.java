package com.minoterie.projet.services;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.StockMatierePremiere;
import com.minoterie.projet.domain.StockProduitsFinis;


@Local
public interface StockServicesLocal {
	
	public List<StockMatierePremiere> getStockMPbyday();
	public List<StockMatierePremiere> getStockMPbyWeek();
	public List<StockMatierePremiere> getStockMPbyMonth();
	public List<StockMatierePremiere> getStockMPbyYear();
	
	public List<StockProduitsFinis> getStockProdFinibyDay();
	public List<StockProduitsFinis> getStockProdFinibyWeek();
	public List<StockProduitsFinis> getStockProdFinibyMonth();
	public List<StockProduitsFinis> getStockProdFinibyYear();

	
	
	
	

}
