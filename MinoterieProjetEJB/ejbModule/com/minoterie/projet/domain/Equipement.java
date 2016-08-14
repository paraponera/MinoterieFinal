package com.minoterie.projet.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Equipement
 *
 */
@Entity

public class Equipement implements Serializable {

	
	private int idEquipement;
	private String nom;
	private String region;
	private String type;
	private Site site ;
	private List<Point> points ;
	private static final long serialVersionUID = 1L;

	public Equipement() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getIdEquipement() {
		return this.idEquipement;
	}

	public void setIdEquipement(int idEquipement) {
		this.idEquipement = idEquipement;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ManyToOne
	@JoinColumn(name = "site_fk")
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	@OneToMany(mappedBy="equipement", cascade=CascadeType.ALL)
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
   
}
