package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.StockMatierePremiere;

@Local
public interface StockMatPreDaoLocal {
	public void inserer_modifierMatPrem(StockMatierePremiere stockm);
    public void deletematPrem(StockMatierePremiere stockm);
    public StockMatierePremiere getById(int Id_stockm);
    public List<StockMatierePremiere> getAll();
    public double getMaxMP();


}
