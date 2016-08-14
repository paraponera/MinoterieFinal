package com.minoterie.projet.services;

import javax.ejb.Local;

import com.minoterie.projet.domain.Point;

@Local
public interface PowerServiceLocal {

	public Point getPuissance();
	public Point getCourrant();
	public Point getCosphi();
}
