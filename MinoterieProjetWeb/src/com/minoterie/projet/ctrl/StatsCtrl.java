package com.minoterie.projet.ctrl;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;

import com.minoterie.projet.domain.Point;
import com.minoterie.projet.services.PowerServiceLocal;
import com.minoterie.projet.services.StatistiqueServiceLocal;

@ManagedBean
@SessionScoped
public class StatsCtrl {
	
	
	@EJB
	PowerServiceLocal powerServiceLocal ;
	
	@EJB
	StatistiqueServiceLocal statistiqueServiceLocal;
	
	public List<Point> p = new ArrayList<Point>();
	
	public LineChartModel puissanceD  = new LineChartModel() ;
	public LineChartModel cosphiD  = new LineChartModel();
	public LineChartModel courantD = new LineChartModel();
	
	private String pui;
	private String cou;
	private String cos;
	
	public StatsCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init(){
	  createPuissanceD();
	  createCosphi();
	  createCourrant();
	}
	

	
	public void createPuissanceD(){
		puissanceD = initCategoryModel();
		puissanceD.setTitle("Suivi Puissance / jour");
		puissanceD.setZoom(true);
		puissanceD.getAxis(AxisType.Y).setLabel("En Kw");
		DateAxis axis = new DateAxis("Dates");
		axis.setTickAngle(-50);

		axis.setTickFormat(" %#d %b , %y");

		puissanceD.getAxes().put(AxisType.X, axis);
	}
	
	


	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();
		ChartSeries series1 = new ChartSeries("Puissance");

		List<Point> puissances = statistiqueServiceLocal.getPuissaceByDay();
		for (Point puissanceJ : puissances) {
			series1.set(puissanceJ.getDate().toString(), puissanceJ.getValeur());
			
		}
		model.addSeries(series1);
	
		return model;

	}

	
	public void createCosphi(){
		cosphiD = initCategoryModel1();
		cosphiD.setTitle("Suivi Cosphi / jour");
		cosphiD.setZoom(true);
		cosphiD.getAxis(AxisType.Y).setLabel("En Kw");
		DateAxis axis = new DateAxis("Dates");
		axis.setTickAngle(-50);

		axis.setTickFormat(" %#d %b , %y");

		cosphiD.getAxes().put(AxisType.X, axis);
	}
	
	


	private LineChartModel initCategoryModel1() {
		LineChartModel model = new LineChartModel();
		ChartSeries series1 = new ChartSeries("cosphi");

		List<Point> puissances = statistiqueServiceLocal.getCosphiByDay();
		for (Point puissanceJ : puissances) {
			series1.set(puissanceJ.getDate().toString(), puissanceJ.getValeur());
			
		}
		model.addSeries(series1);
	
		return model;

	}

	
	
	public void createCourrant(){
		courantD = initCategoryModel2();
		courantD.setTitle("Suivi Puissance / jour");
		courantD.setZoom(true);
		courantD.getAxis(AxisType.Y).setLabel("En Kw");
		DateAxis axis = new DateAxis("Dates");
		axis.setTickAngle(-50);

		axis.setTickFormat(" %#d %b , %y");

		courantD.getAxes().put(AxisType.X, axis);
	}
	
	


	private LineChartModel initCategoryModel2() {
		LineChartModel model = new LineChartModel();
		ChartSeries series1 = new ChartSeries();

		List<Point> puissances = statistiqueServiceLocal.getCourantByDay();
		for (Point puissanceJ : puissances) {
			series1.set(puissanceJ.getDate().toString(), puissanceJ.getValeur());
			
		}
		model.addSeries(series1);
	
		return model;

	}

	
	
	public void refreshChartPuissance() {
		buildChartPuissance();
	}

	private void buildChartPuissance() {
		if (pui.equals("week")) {
			System.out.println("je suis la");
			LineChartModel model = new LineChartModel();
			ChartSeries series1 = new ChartSeries("Puissance");

			List<Point> weekstocks = statistiqueServiceLocal.getPuissancebyWeek();
			for (Point weekstock : weekstocks) {
				series1.set(weekstock.getDate().toString(), weekstock.getValeur());
                System.out.println(weekstock.toString());
			}
			model.addSeries(series1);
			puissanceD = model;
			puissanceD.setTitle("Suivi Puissanceuction Blé/farine/Semoule");
			puissanceD.setZoom(true);
			puissanceD.getAxis(AxisType.Y).setLabel("En Kw");
			puissanceD.getAxis(AxisType.Y).setMax(100);
			DateAxis axis = new DateAxis("Dates");
			axis.setTickAngle(-50);

			axis.setTickFormat(" %#d %b , %y");

			puissanceD.getAxes().put(AxisType.X, axis);

		} else if (pui.equals("month")) {
			LineChartModel model = new LineChartModel();
			ChartSeries series1 = new ChartSeries();

			List<Point> weekstocks = statistiqueServiceLocal.getStockPuissancebyMonth();
			for (Point weekstock : weekstocks) {
				series1.set(weekstock.getDate().toString(), weekstock.getValeur());

			}
			model.addSeries(series1);

			puissanceD = model;
			puissanceD.setTitle("Puissance");
			puissanceD.setZoom(true);
			puissanceD.getAxis(AxisType.Y).setLabel("En Kw");
			puissanceD.getAxis(AxisType.Y).setMax(100);
			DateAxis axis = new DateAxis("Dates");
			axis.setTickAngle(-50);

			axis.setTickFormat(" %#d %b , %y");

			puissanceD.getAxes().put(AxisType.X, axis);

		} 

	}
	


	public void refreshChartCoshpi() {
		buildChartCoshpi();
	}

	private void buildChartCoshpi() {
		if (cos.equals("week")) {
			LineChartModel model = new LineChartModel();
			ChartSeries series1 = new ChartSeries("Coshpi");

			List<Point> weekstocks = statistiqueServiceLocal.getStockCosphibyWeek();
			for (Point weekstock : weekstocks) {
				series1.set(weekstock.getDate().toString(), weekstock.getValeur());

			}
			model.addSeries(series1);
			cosphiD = model;
			cosphiD.setTitle("Cosphi");
			cosphiD.setZoom(true);
			cosphiD.getAxis(AxisType.Y).setLabel("En cosphi");
			cosphiD.getAxis(AxisType.Y).setMax(100);
			DateAxis axis = new DateAxis("Dates");
			axis.setTickAngle(-50);

			axis.setTickFormat(" %#d %b , %y");
			cosphiD.getAxes().put(AxisType.X, axis);

		} else if (cos.equals("month")) {
			LineChartModel model = new LineChartModel();
			ChartSeries series1 = new ChartSeries();

			List<Point> weekstocks = statistiqueServiceLocal.getStockCosphibyMonth();
			for (Point weekstock : weekstocks) {
				series1.set(weekstock.getDate().toString(), weekstock.getValeur());

			}
			model.addSeries(series1);

			cosphiD = model;
			cosphiD.setTitle("Coshpi");
			cosphiD.setZoom(true);
			cosphiD.getAxis(AxisType.Y).setLabel("En cosphi");
			cosphiD.getAxis(AxisType.Y).setMax(100);
			DateAxis axis = new DateAxis("Dates");
			axis.setTickAngle(-50);

			axis.setTickFormat(" %#d %b , %y");

			cosphiD.getAxes().put(AxisType.X, axis);

		} 

	}

	


	public void refreshChartCourant() {
		buildChartCourant();
	}

	private void buildChartCourant() {
		if (cou.equals("week")) {
			LineChartModel model = new LineChartModel();
			ChartSeries series1 = new ChartSeries("Courant");

			List<Point> weekstocks = statistiqueServiceLocal.getStockCourantbyWeek();
			for (Point weekstock : weekstocks) {
				series1.set(weekstock.getDate().toString(), weekstock.getValeur());

			}
			model.addSeries(series1);
			courantD = model;
			courantD.setTitle("Cosphi");
			courantD.setZoom(true);
			courantD.getAxis(AxisType.Y).setLabel("En courant");
			courantD.getAxis(AxisType.Y).setMax(100);
			DateAxis axis = new DateAxis("Dates");
			axis.setTickAngle(-50);

			axis.setTickFormat(" %#d %b , %y");

			courantD.getAxes().put(AxisType.X, axis);

		} else if (cou.equals("month")) {
			LineChartModel model = new LineChartModel();
			ChartSeries series1 = new ChartSeries();

			List<Point> weekstocks = statistiqueServiceLocal.getStockCourantbyMonth();
			for (Point weekstock : weekstocks) {
				series1.set(weekstock.getDate().toString(), weekstock.getValeur());

			}
			model.addSeries(series1);

			courantD = model;
			courantD.setTitle("Courant");
			courantD.setZoom(true);
			courantD.getAxis(AxisType.Y).setLabel("En courant");
			courantD.getAxis(AxisType.Y).setMax(100);
			DateAxis axis = new DateAxis("Dates");
			axis.setTickAngle(-50);

			axis.setTickFormat(" %#d %b , %y");

			courantD.getAxes().put(AxisType.X, axis);

		} 

	}


	

	

	public List<Point> getP() {
		return p;
	}

	public void setP(List<Point> p) {
		this.p = p;
	}

	public LineChartModel getPuissanceD() {
		
		return puissanceD;
	}

	public void setPuissanceD(LineChartModel puissanceD) {
		this.puissanceD = puissanceD;
	}

	public LineChartModel getCosphiD() {
		return cosphiD;
	}

	public void setCosphiD(LineChartModel cosphiD) {
		this.cosphiD = cosphiD;
	}

	public LineChartModel getCourantD() {
		return courantD;
	}

	public void setCourantD(LineChartModel courantD) {
		this.courantD = courantD;
	}

	public String getPui() {
		return pui;
	}

	public void setPui(String pui) {
		this.pui = pui;
	}

	public String getCou() {
		return cou;
	}

	public void setCou(String cou) {
		this.cou = cou;
	}

	public String getCos() {
		return cos;
	}

	public void setCos(String cos) {
		this.cos = cos;
	}

	
	
}
