package com.conversor.modelo;

import javax.swing.ImageIcon;

public enum ListaMonedas implements MetodosUnidades{
	
	
	USD ("USD", "Dólar Americano", 1, new ImageIcon("src/Assets/Images/LogosBanderas/US.png")),
	EUR ("EUR", "Euro", 1.10156, new ImageIcon("src/Assets/Images/LogosBanderas/EU.png")),
	MXN ("MXN", "Peso Mexicano", 0.0599273, new ImageIcon("src/Assets/Images/LogosBanderas/MX.png")),
	PEN ("PEN", "Sol Peruano", 0.28, new ImageIcon("src/Assets/Images/LogosBanderas/PE.png")),
	GBP ("GBP", "Libra Esterlina", 1.28487, new ImageIcon("src/Assets/Images/LogosBanderas/GB.png")),
	JPY ("JPY", "Yen Japonés", 0.00708422, new ImageIcon("src/Assets/Images/LogosBanderas/JP.png")),
	KRW ("KRW", "Won Surcoreano", 0.000785195, new ImageIcon("src/Assets/Images/LogosBanderas/KR.png")),
	BRL ("BRL", "Real Brasileño", 0.211448, new ImageIcon("src/Assets/Images/LogosBanderas/BR.png")),
	ARS ("ARS", "Peso Argentino", 0.00365467, new ImageIcon("src/Assets/Images/LogosBanderas/AR.png")),
	COP ("COP", "Peso Colombiano", 0.000255481, new ImageIcon("src/Assets/Images/LogosBanderas/co.png"))
	;
	
	private String unidad;
	private String nombreUnidad;
	private double valor;
	private ImageIcon icon;
	ImageIcon img = new ImageIcon();
	
	private ListaMonedas(String unidad, String nombreUnidad, double valor, ImageIcon icon) {
		this.unidad = unidad;
		this.nombreUnidad = nombreUnidad;
		this.valor = valor;
		this.icon = icon;
	}

	@Override
	public String getUnidad() {
		// TODO Auto-generated method stub
		return this.unidad;
	}

	@Override
	public String getNombreUnidad() {
		// TODO Auto-generated method stub
		return this.nombreUnidad;
	}

	@Override
	public double getValor() {
		// TODO Auto-generated method stub
		return this.valor;
	}
	
	
	@Override
	public ImageIcon getIcon() {
		// TODO Auto-generated method stub
		return this.icon;
	}

}
