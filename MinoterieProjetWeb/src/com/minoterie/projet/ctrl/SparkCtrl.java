package com.minoterie.projet.ctrl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.minoterie.projet.dao.SparkDaoLocal;
import com.minoterie.projet.domain.Spark;

@ManagedBean
@SessionScoped
public class SparkCtrl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public SparkCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	@EJB
	SparkDaoLocal sparkdao ;
	
	public List<Spark> spark = new ArrayList<Spark>();
	
	
	@PostConstruct
	public void init(){
		spark = sparkdao.getAll();
	}

   public void refeshSpark(){
	   System.err.println("je suis appelé");
List<Spark> NewSparks  = sparkdao.getAll();
		if(NewSparks.size()>spark.size()){
			@SuppressWarnings("unused")
			int a=NewSparks.size()-spark.size();
		
			for (int i = spark.size()+1; i <= NewSparks.size(); i++) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "New Spark", "Spark ID :"+NewSparks.get(i-1).getIdSpark()));			}
		}
			spark=NewSparks;
   }
	
	
	public List<Spark> getSpark() {
		return spark;
	}


	public void setSpark(List<Spark> spark) {
		this.spark = spark;
	}
	
	

}
