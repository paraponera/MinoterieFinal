package com.minoterie.projet.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Stock
 *
 */
@Entity

public class Stock implements Serializable {

	
	private int idQuantite;
	private Date date;
	private double quantite;
	private static final long serialVersionUID = 1L;

	public Stock() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdQuantite() {
		return this.idQuantite;
	}

	public void setIdQuantite(int idQuantite) {
		this.idQuantite = idQuantite;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public double getQuantite() {
		return this.quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
   
}
