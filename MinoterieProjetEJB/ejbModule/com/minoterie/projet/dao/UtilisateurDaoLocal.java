package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.Utilisateur;

@Local
public interface UtilisateurDaoLocal {

	public void addUser(Utilisateur users);
	public void updUser(Utilisateur user) ;
	public  Utilisateur findUser(String idUser) ;
	public void delUser(Utilisateur user);
	public List<Utilisateur> getAllUser();
}
