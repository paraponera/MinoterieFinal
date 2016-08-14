package com.minoterie.projet.ctrl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;

import com.minoterie.projet.dao.ProductionDaoLocal;
import com.minoterie.projet.dao.StockDaoLocal;
import com.minoterie.projet.dao.StockMatPreDaoLocal;
import com.minoterie.projet.dao.StockProdFiniDaoLocal;
import com.minoterie.projet.domain.Production;
import com.minoterie.projet.domain.Stock;
import com.minoterie.projet.domain.StockMatierePremiere;
import com.minoterie.projet.domain.StockProduitsFinis;
import com.minoterie.projet.services.StockServicesLocal;

@ManagedBean
@SessionScoped
public class StockCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	StockMatPreDaoLocal stockMatPreDaoLocal;

	@EJB
	StockProdFiniDaoLocal stockProdFiniDaoLocal;
    
	@EJB
	StockDaoLocal stockDaoLocal ;
	
	@EJB
	StockServicesLocal stockServicesLocal;
	
	@EJB
    ProductionDaoLocal productionDaoLocal;

	private List<StockMatierePremiere> matierePremieres = new ArrayList<StockMatierePremiere>();
	private List<StockProduitsFinis> produitsFinis = new ArrayList<StockProduitsFinis>();
	private List<Production> productions = new ArrayList<Production>();
	private StockProduitsFinis stockProduitsFinis = new StockProduitsFinis();
	private StockMatierePremiere stkMP = new StockMatierePremiere();
	private String dateS;
	private Date date;

	
	private String statusMinoterie;
	private String statusFarine ;
	private String statusSemoule;
     private Stock stock= new Stock();
	private LineChartModel dateModelStockMP;
	private LineChartModel prodModel ;
    
	public StockCtrl() {
		// 
	}

	@PostConstruct
	public void init() {
		matierePremieres = stockMatPreDaoLocal.getAll();
		produitsFinis = stockProdFiniDaoLocal.getAll();
        stock = stockDaoLocal.getbydate();
		matierePremiereChart();
		   productions = productionDaoLocal.getPoductionbyMonth();

	}

	public void refreshChart() {
		buildChart();
	}

	private void buildChart() {
		if (dateS.equals("week")) {
			LineChartModel model = new LineChartModel();
			ChartSeries series1 = new ChartSeries();
			ChartSeries series2 = new ChartSeries();
			ChartSeries series3 = new ChartSeries();
			List<StockMatierePremiere> weekstocks = stockServicesLocal.getStockMPbyWeek();
			for (StockMatierePremiere weekstock : weekstocks) {
				series1.set(weekstock.getDate().toString(), weekstock.getBle());
				series2.set(weekstock.getDate().toString(), weekstock.getBleToFarine());
				series3.set(weekstock.getDate().toString(), weekstock.getBleToSemoule());
			}
			model.addSeries(series1);
			model.addSeries(series2);
			model.addSeries(series3);
			dateModelStockMP = model;
			dateModelStockMP.setTitle("Suivi Production Blé/farine/Semoule");
			dateModelStockMP.setZoom(true);
			dateModelStockMP.getAxis(AxisType.Y).setLabel("En kg");
			dateModelStockMP.getAxis(AxisType.Y).setMax(100);
			DateAxis axis = new DateAxis("Dates");
			axis.setTickAngle(-50);

			axis.setTickFormat(" %#d %b , %y");

			dateModelStockMP.getAxes().put(AxisType.X, axis);

		} else if (dateS.equals("month")) {
			LineChartModel model = new LineChartModel();
			ChartSeries series1 = new ChartSeries();
			ChartSeries series2 = new ChartSeries();
			ChartSeries series3 = new ChartSeries();
			List<StockMatierePremiere> weekstocks = stockServicesLocal.getStockMPbyMonth();
			for (StockMatierePremiere weekstock : weekstocks) {
				series1.set(weekstock.getDate().toString(), weekstock.getBle());
				series2.set(weekstock.getDate().toString(), weekstock.getBleToFarine());
				series3.set(weekstock.getDate().toString(), weekstock.getBleToSemoule());
			}
			model.addSeries(series1);
			model.addSeries(series2);
			model.addSeries(series3);
			dateModelStockMP = model;
			dateModelStockMP.setTitle("Suivi Production Blé/farine/Semoule");
			dateModelStockMP.setZoom(true);
			dateModelStockMP.getAxis(AxisType.Y).setLabel("En Kg");
			dateModelStockMP.getAxis(AxisType.Y).setMax(100);
			DateAxis axis = new DateAxis("Dates");
			axis.setTickAngle(-50);

			axis.setTickFormat(" %#d %b , %y");

			dateModelStockMP.getAxes().put(AxisType.X, axis);

		} else if (dateS.equalsIgnoreCase("year")) {
			LineChartModel model = new LineChartModel();
			ChartSeries series1 = new ChartSeries();
			ChartSeries series2 = new ChartSeries();
			ChartSeries series3 = new ChartSeries();
			List<StockMatierePremiere> weekstocks = stockServicesLocal.getStockMPbyYear();
			for (StockMatierePremiere weekstock : weekstocks) {
				series1.set(weekstock.getDate().toString(), weekstock.getBle());
				series2.set(weekstock.getDate().toString(), weekstock.getBleToFarine());
				series3.set(weekstock.getDate().toString(), weekstock.getBleToSemoule());
			}
			model.addSeries(series1);
			model.addSeries(series2);
			model.addSeries(series3);
			dateModelStockMP = model;
			dateModelStockMP.setTitle("Suivi Production Blé/farine/Semoule");
			dateModelStockMP.setZoom(true);
			dateModelStockMP.getAxis(AxisType.Y).setLabel("En Kg");
			dateModelStockMP.getAxis(AxisType.Y).setMax(100);
			DateAxis axis = new DateAxis("Dates");
			axis.setTickAngle(-50);

			axis.setTickFormat(" %#d %b , %y");

			dateModelStockMP.getAxes().put(AxisType.X, axis);
		}

	}

	private void matierePremiereChart() {
		dateModelStockMP = initCategoryModel();
		dateModelStockMP.setTitle("Suivi Prévision Blé/farine/Semoule");
		dateModelStockMP.setZoom(true);
		dateModelStockMP.getAxis(AxisType.Y).setLabel("En Kg");
		dateModelStockMP.getAxis(AxisType.Y).setMax(100);
		dateModelStockMP.setLegendPosition("ne");
		DateAxis axis = new DateAxis("Dates");
		axis.setTickAngle(-50);

		axis.setTickFormat(" %#d %b , %y");

		dateModelStockMP.getAxes().put(AxisType.X, axis);
	}

	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();
		ChartSeries series1 = new ChartSeries("Blé");
		ChartSeries series2 = new ChartSeries("Farine");
		ChartSeries series3 = new ChartSeries("Semoule");
		List<StockMatierePremiere> weekstocks = stockServicesLocal.getStockMPbyWeek();
		for (StockMatierePremiere weekstock : weekstocks) {
			series1.set(weekstock.getDate().toString(), weekstock.getBle());
			series2.set(weekstock.getDate().toString(), weekstock.getBleToFarine());
			series3.set(weekstock.getDate().toString(), weekstock.getBleToSemoule());
		}
		model.addSeries(series1);
		model.addSeries(series2);
		model.addSeries(series3);
		return model;

	}
	
	

	public void addMP() {
		try {
             Stock sts = new Stock();
			 Date d = new  Date();
			 stkMP.setDate(d);
			 sts.setDate(d);
		    System.out.println(stkMP.toString());
			 stockMatPreDaoLocal.inserer_modifierMatPrem(stkMP);
			 double val = stkMP.getBle() + stock.getQuantite();
			 sts.setQuantite(val);
			 System.out.println(val);
			 stock = stockDaoLocal.getbydate();
             stockDaoLocal.inserer_modifierSpark(sts);
			 matierePremieres = stockMatPreDaoLocal.getAll();
			 
			 stkMP = new StockMatierePremiere();

		} catch (Exception e) {
			System.out.println("erreur " + e.getMessage());
		}



	}

	
	public void addPF() {
		try {
			System.out.println("cliked");
			 Date d = new  Date();
			 stockProduitsFinis.setDate(d);
			 System.out.println(stockProduitsFinis.toString());
			 stockProdFiniDaoLocal.inserer_modifierStockF(stockProduitsFinis);
				produitsFinis = stockProdFiniDaoLocal.getAll();
				System.out.println("je suis en 2eme");
			 try {
				 System.out.println("je suis la  en 1er");
				 CalculateRendoment(stockProduitsFinis.getFarine(), stockProduitsFinis.getSemoule(),stkMP.getBleToFarine(),stkMP.getBleToSemoule());
				  System.out.println("JE SUIS NNO PAS");
				 calculteStockBle(stockProduitsFinis.getFarine(), stockProduitsFinis.getSemoule());
			} catch (Exception e) {
				System.out.println("Erreur +" + e.getMessage());
			}
			
				
		        stock = stockDaoLocal.getbydate();

				stockProduitsFinis = new StockProduitsFinis();
				
				productions= productionDaoLocal.getPoductionbyMonth();
		} catch (Exception e) {
			System.out.println("erreur" + e.getMessage());
		}


	}

	private void calculteStockBle(double farine, double semoule){
		Date d = new Date();
		Stock sts2 = new Stock();
		System.out.println(farine + " " + semoule);
		double somme = farine + semoule;
		double ble = stockDaoLocal.getbydate().getQuantite();
		System.out.println(ble);
		double quantite = (ble - somme);
		System.out.println(quantite);
		if ( quantite <0  )  ble =  0 ;
		try {
			sts2.setDate(d);
			sts2.setQuantite(quantite);
			stockDaoLocal.inserer_modifierSpark(sts2);
		} catch (Exception e) {
			System.out.println("erreur " + e.getMessage());
		}
		
	}
	
    
	private void CalculateRendoment(double farine,double semoule,double farineR, double semouleR){
		System.out.println(farine + " " + semoule + " " + farineR + " " + semouleR);
	    try {
	    	Production production = new Production();
			double totale = (farine *0.5) ;
			double totaleRepartion = stockDaoLocal.getbydate().getQuantite();
			totaleRepartion = totaleRepartion * 0.5 ;        
			if (totale >= totaleRepartion) {
				production.setRendementTotale("parfait");
				statusMinoterie="normale";
			}
			else {
				production.setRendementTotale("mauvaise");
				statusMinoterie="mauvaise";

			}
			
		    double rFarine1 = (0.74* farineR );
		    double rSemoule1 = (0.74* semouleR);
		    double rFarine2 = (0.76* farineR );
		    double rSemoule2 = (0.76* semouleR);
		    
		    if (  farine >=  rFarine1  && farine <= rFarine2 ) {
		    	 production.setRendementFarine("Normale");
		    	 statusFarine="Normale";
		    }
		    else if (farine <=  rFarine1) {
		    	production.setRendementFarine("sous production");
		    	 statusFarine="sous production";

		    }
		    else if (farine >= rFarine2) {
		    	production.setRendementFarine("sur production");
		    	 statusFarine="sur production";
		    }
		    
		    if (  semoule >=  rSemoule1  && farine <= rSemoule2 ) {
		    	 production.setRendomentSemoule("Normale");
		    	 statusSemoule= "Normale";
		    }
		    else if (semoule <=  rSemoule1) {
		    	production.setRendomentSemoule("sous production");
		    	 statusSemoule= "sous production";

		    }
		    else if (semoule >= rSemoule2) {
		    	production.setRendomentSemoule("sur production");
		    	 statusSemoule= "sur production";

		    }
		    Date date = new Date();
		    production.setDate(date);
		    productionDaoLocal.addProduction(production);
		    
		} catch (Exception e) {
			System.out.println("erreur " + e.getMessage());
		}
	}
	

	
	public List<StockMatierePremiere> getMatierePremieres() {
		return matierePremieres;
	}

	public void setMatierePremieres(List<StockMatierePremiere> matierePremieres) {
		this.matierePremieres = matierePremieres;
	}

	public LineChartModel getDateModelStockMP() {
		return dateModelStockMP;
	}

	public void setDateModelStockMP(LineChartModel dateModelStockMP) {
		this.dateModelStockMP = dateModelStockMP;
	}

	

	public List<StockProduitsFinis> getProduitsFinis() {
		return produitsFinis;
	}

	public void setProduitsFinis(List<StockProduitsFinis> produitsFinis) {
		this.produitsFinis = produitsFinis;
	}

	public String getDateS() {
		return dateS;
	}

	public void setDateS(String dateS) {
		this.dateS = dateS;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StockProduitsFinis getStockProduitsFinis() {
		return stockProduitsFinis;
	}

	public void setStockProduitsFinis(StockProduitsFinis stockProduitsFinis) {
		this.stockProduitsFinis = stockProduitsFinis;
	}





	public StockMatierePremiere getStkMP() {
		return stkMP;
	}

	public void setStkMP(StockMatierePremiere stkMP) {
		this.stkMP = stkMP;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public LineChartModel getProdModel() {
		return prodModel;
	}

	public void setProdModel(LineChartModel prodModel) {
		this.prodModel = prodModel;
	}

	public List<Production> getProductions() {
		return productions;
	}

	public void setProductions(List<Production> productions) {
		this.productions = productions;
	}

	public String getStatusFarine() {
		return statusFarine;
	}

	public void setStatusFarine(String statusFarine) {
		this.statusFarine = statusFarine;
	}

	public String getStatusMinoterie() {
		return statusMinoterie;
	}

	public void setStatusMinoterie(String statusMinoterie) {
		this.statusMinoterie = statusMinoterie;
	}

	public String getStatusSemoule() {
		return statusSemoule;
	}

	public void setStatusSemoule(String statusSemoule) {
		this.statusSemoule = statusSemoule;
	}


	
	

}
