package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.Spark;

@Local
public interface SparkDaoLocal {


	public void inserer_modifierSpark(Spark spark);
    public void deleteSpark(Spark spark);
    public Spark getById(int Id_spark);
    public List<Spark> getAll();

}
