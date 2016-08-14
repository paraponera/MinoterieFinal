package com.minoterie.projet.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: StockMatierePremiere
 *
 */
@Entity

public class StockMatierePremiere implements Serializable {

	
	private int idStockMatierePremiere;
	private double ble;
	private double bleToFarine;
	private double bleToSemoule ;
	private double quatiteEnStock;
	private Date date;
	private static final long serialVersionUID = 1L;

	public StockMatierePremiere() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getIdStockMatierePremiere() {
		return this.idStockMatierePremiere;
	}

	public void setIdStockMatierePremiere(int idStockMatierePremiere) {
		this.idStockMatierePremiere = idStockMatierePremiere;
	}   
	
	public double getBle() {
		return this.ble;
	}

	public void setBle(double ble) {
		this.ble = ble;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	public double getBleToFarine() {
		return bleToFarine;
	}
	public void setBleToFarine(double bleToFarine) {
		this.bleToFarine = bleToFarine;
	}
	public double getBleToSemoule() {
		return bleToSemoule;
	}
	public void setBleToSemoule(double bleToSemoule) {
		this.bleToSemoule = bleToSemoule;
	}
	@Override
	public String toString() {
		return "StockMatierePremiere [idStockMatierePremiere=" + idStockMatierePremiere + ", ble=" + ble
				+ ", bleToFarine=" + bleToFarine + ", bleToSemoule=" + bleToSemoule + ", date=" + date + "]";
	}
	public double getQuatiteEnStock() {
		return quatiteEnStock;
	}
	public void setQuatiteEnStock(double quatiteEnStock) {
		this.quatiteEnStock = quatiteEnStock;
	}

	
	
	
}
