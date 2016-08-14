package com.minoterie.projet.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rapport
 *
 */
@Entity

public class Rapport implements Serializable {

	
	private int idRapport;
	private boolean rapportJournalier;
	private boolean rapportMensuel;
	private String contenu;
	private static final long serialVersionUID = 1L;

	public Rapport() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getIdRapport() {
		return this.idRapport;
	}

	public void setIdRapport(int idRapport) {
		this.idRapport = idRapport;
	}   
	public boolean getRapportJournalier() {
		return this.rapportJournalier;
	}

	public void setRapportJournalier(boolean rapportJournalier) {
		this.rapportJournalier = rapportJournalier;
	}   
	public boolean getRapportMensuel() {
		return this.rapportMensuel;
	}

	public void setRapportMensuel(boolean rapportMensuel) {
		this.rapportMensuel = rapportMensuel;
	}   
	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
   
}
