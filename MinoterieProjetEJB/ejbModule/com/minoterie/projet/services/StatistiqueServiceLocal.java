package com.minoterie.projet.services;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.Point;


@Local
public interface StatistiqueServiceLocal {
	
	public List<Point> getPuissaceByDay();
	public List<Point> getPuissancebyWeek();
	public List<Point> getStockPuissancebyMonth();
	public List<Point> getStockPuissancebyYear();
	
	public List<Point> getCourantByDay();
	public List<Point> getStockCourantbyWeek();
	public List<Point> getStockCourantbyMonth();
	public List<Point> getStockCourantbyYear();
	
	public List<Point> getCosphiByDay();
	public List<Point> getStockCosphibyWeek();
	public List<Point> getStockCosphibyMonth();
	public List<Point> getStockCosphibyYear();
	
	

}
