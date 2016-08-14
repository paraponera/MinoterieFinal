package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.Point;

@Local
public interface PointDaoLocal {

	public void inserer_modifierPoint(Point pnt);
    public void deletePoint(Point pnt);
    public Point getById(int Id_pnt);
    public List<Point> getAll();
    public Point GetPointByName(String nom);
}
