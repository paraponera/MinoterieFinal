package com.minoterie.projet.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: StockProduitsFinis
 *
 */
@Entity

public class StockProduitsFinis implements Serializable {

	   
	
	private int idStockProduitsFinis;
	private double farine;
    private double semoule;
	private Date date;
	private static final long serialVersionUID = 1L;

	public StockProduitsFinis() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getIdStockProduitsFinis() {
		return this.idStockProduitsFinis;
	}

	public void setIdStockProduitsFinis(int idStockProduitsFinis) {
		this.idStockProduitsFinis = idStockProduitsFinis;
	}   
	public double getFarine() {
		return this.farine;
	}

	public void setFarine(double farine) {
		this.farine = farine;
	}   

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getSemoule() {
		return semoule;
	}

	public void setSemoule(double semoule) {
		this.semoule = semoule;
	}
   
}
