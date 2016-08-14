package com.minoterie.projet.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.minoterie.projet.domain.Equipement;

/**
 * Entity implementation class for Entity: Site
 *
 */
@Entity

public class Site implements Serializable {

	
	private int idSite;
	private String nomSite;
	private double area;
	private String geoAddress;
	private String geoCity;
	private Date occupiedStart;
	private Date occupiedEnd;
	private String weatherRef;
	private int phone;
	private String etat ;
	private List<Equipement> equipements;
	private static final long serialVersionUID = 1L;

	public Site() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getIdSite() {
		return this.idSite;
	}

	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}   
	public String getNomSite() {
		return this.nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}   
	public double getArea() {
		return this.area;
	}

	public void setArea(double area) {
		this.area = area;
	}   
	public String getGeoAddress() {
		return this.geoAddress;
	}

	public void setGeoAddress(String geoAddress) {
		this.geoAddress = geoAddress;
	}   
	public String getGeoCity() {
		return this.geoCity;
	}

	public void setGeoCity(String geoCity) {
		this.geoCity = geoCity;
	}   
	public Date getOccupiedStart() {
		return this.occupiedStart;
	}

	public void setOccupiedStart(Date occupiedStart) {
		this.occupiedStart = occupiedStart;
	}   
	public Date getOccupiedEnd() {
		return this.occupiedEnd;
	}

	public void setOccupiedEnd(Date occupiedEnd) {
		this.occupiedEnd = occupiedEnd;
	}   
	public String getWeatherRef() {
		return this.weatherRef;
	}

	public void setWeatherRef(String weatherRef) {
		this.weatherRef = weatherRef;
	}   
	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	@OneToMany(mappedBy="site", cascade=CascadeType.ALL)
	public List<Equipement> getEquipements() {
		return equipements;
	}
	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
   
}
