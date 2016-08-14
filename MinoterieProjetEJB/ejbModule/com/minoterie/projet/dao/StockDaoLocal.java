package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.Stock;


@Local
public interface StockDaoLocal {

	public void inserer_modifierSpark(Stock spark);
	public Stock getbydate();
    public List<Stock> getAll();
}
