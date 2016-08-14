package com.minoterie.projet.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Spark
 *
 */
@Entity

public class Spark implements Serializable {

	
	private int idSpark;
	private Date date;
	private String duree;
	private String typeSpark;
	private String siteRef;
	private static final long serialVersionUID = 1L;

	public Spark() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getIdSpark() {
		return this.idSpark;
	}

	public void setIdSpark(int idSpark) {
		this.idSpark = idSpark;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public String getDuree() {
		return this.duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}   
	public String getTypeSpark() {
		return this.typeSpark;
	}

	public void setTypeSpark(String typeSpark) {
		this.typeSpark = typeSpark;
	}   
	public String getSiteRef() {
		return this.siteRef;
	}

	public void setSiteRef(String siteRef) {
		this.siteRef = siteRef;
	}
   
}
