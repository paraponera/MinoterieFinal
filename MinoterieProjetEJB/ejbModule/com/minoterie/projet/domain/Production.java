package com.minoterie.projet.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Production
 *
 */
@Entity

public class Production implements Serializable {

	
	private int idProduction;
	private Date date;
	private String rendementFarine;
	private String rendomentSemoule;
	private String rendementTotale;
	private static final long serialVersionUID = 1L;

	public Production() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdProduction() {
		return this.idProduction;
	}

	public void setIdProduction(int idProduction) {
		this.idProduction = idProduction;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public String getRendementFarine() {
		return this.rendementFarine;
	}

	public void setRendementFarine(String rendementFarine) {
		this.rendementFarine = rendementFarine;
	}   
	public String getRendomentSemoule() {
		return this.rendomentSemoule;
	}

	public void setRendomentSemoule(String rendomentSemoule) {
		this.rendomentSemoule = rendomentSemoule;
	}   
	public String getRendementTotale() {
		return this.rendementTotale;
	}

	public void setRendementTotale(String rendementTotale) {
		this.rendementTotale = rendementTotale;
	}
	@Override
	public String toString() {
		return "Production [idProduction=" + idProduction + ", date=" + date + ", rendementFarine=" + rendementFarine
				+ ", rendomentSemoule=" + rendomentSemoule + ", rendementTotale=" + rendementTotale + "]";
	}   

   
}
