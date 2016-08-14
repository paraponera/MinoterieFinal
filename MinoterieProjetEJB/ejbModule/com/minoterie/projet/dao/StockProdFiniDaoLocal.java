package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.StockProduitsFinis;

@Local
public interface StockProdFiniDaoLocal {
	public void inserer_modifierStockF(StockProduitsFinis stockF);
    public void deleteStockF(StockProduitsFinis stockF);
    public StockProduitsFinis getById(int Id_stockF);
    public List<StockProduitsFinis> getAll();
    public double getMaxProdFini();

}
