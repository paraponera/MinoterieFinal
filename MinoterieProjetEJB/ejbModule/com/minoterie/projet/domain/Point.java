package com.minoterie.projet.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Point
 *
 */
@Entity

public class Point implements Serializable {

	
	private int idPoint;
	private String nom;
	private String type;
	private double valeur;
	private Date date;
	private Equipement equipement ;
	private static final long serialVersionUID = 1L;

	public Point() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getIdPoint() {
		return this.idPoint;
	}

	public void setIdPoint(int idPoint) {
		this.idPoint = idPoint;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public double getValeur() {
		return this.valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToOne
	@JoinColumn(name = "equipement_fk")
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
   
}
