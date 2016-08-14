package com.minoterie.projet.dao;

import java.util.List;

import javax.ejb.Local;

import com.minoterie.projet.domain.Site;

@Local
public interface SiteDaoLocal {


	public void inserer_modifierSite(Site ste);
    public void deleteSite(Site ste);
    public Site getById(int Id_STE);
    public List<Site> getAll();

}
