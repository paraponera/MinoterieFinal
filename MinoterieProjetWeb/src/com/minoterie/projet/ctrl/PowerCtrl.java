package com.minoterie.projet.ctrl;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.minoterie.projet.services.PowerServiceLocal;

@ManagedBean
@SessionScoped
public class PowerCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	PowerServiceLocal powerServiceLocal;

	public String puissance = null;
	public String cosphi = null;
	public String courant = null;
	public String viewId = null;

	public String dateP = null;
	public String dateCos = null;
	public String dateC = null;

	public PowerCtrl() {

	}

	@PostConstruct
	public void init() {
		try {
			DecimalFormat df = new DecimalFormat("#.##");
			puissance = df.format(powerServiceLocal.getPuissance().getValeur());
			cosphi = df.format(powerServiceLocal.getCosphi().getValeur());
			courant = df.format(powerServiceLocal.getCourrant().getValeur());
			viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			dateP = formatter.format(powerServiceLocal.getPuissance().getDate());
			dateCos = formatter.format(powerServiceLocal.getCosphi().getDate());
			dateC = formatter.format(powerServiceLocal.getCourrant().getDate());

		} catch (Exception e) {
			DecimalFormat df = new DecimalFormat("#.##");
			puissance = df.format(0);
			cosphi = df.format(0);
			courant = df.format(0);
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			Date d = new Date();
			dateP = formatter.format(d);
			dateCos = formatter.format(d);
			dateC = formatter.format(d);
		}

	}

	public String getDateP() {
		return dateP;
	}

	public void setDateP(String dateP) {
		this.dateP = dateP;
	}

	public String getDateCos() {
		return dateCos;
	}

	public void setDateCos(String dateCos) {
		this.dateCos = dateCos;
	}

	public String getDateC() {
		return dateC;
	}

	public void setDateC(String dateC) {
		this.dateC = dateC;
	}

	public String getViewId() {
		return viewId;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
	}

	public void getStock() {
		try {

			FacesContext.getCurrentInstance().getExternalContext().redirect("stock.jsf");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void gethome() {
		try {

			FacesContext.getCurrentInstance().getExternalContext().redirect("admin.jsf");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void getuser() {
		try {

			FacesContext.getCurrentInstance().getExternalContext().redirect("user.jsf");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void getstats() {
		try {

			FacesContext.getCurrentInstance().getExternalContext().redirect("stats.jsf");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void getSpark() {
		try {

			FacesContext.getCurrentInstance().getExternalContext().redirect("sparks.jsf");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public String getPuissance() {
		return puissance;
	}

	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}

	public String getCosphi() {
		return cosphi;
	}

	public void setCosphi(String cosphi) {
		this.cosphi = cosphi;
	}

	public String getCourant() {
		return courant;
	}

	public void setCourant(String courant) {
		this.courant = courant;
	}

}
