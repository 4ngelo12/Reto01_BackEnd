package com.conversor.modelo;

import javax.swing.ImageIcon;

public enum ListaMonedas implements MetodosUnidades{
	USD ("USD", 1, new ImageIcon("src/Assets/Images/LogosBanderas/US.png")),
	EUR ("EUR", 1.10156, new ImageIcon("src/Assets/Images/LogosBanderas/EU.png")),
	MXN ("MXN", 0.0599273, new ImageIcon("src/Assets/Images/LogosBanderas/MX.png")),
	PEN ("PEN", 0.28, new ImageIcon("src/Assets/Images/LogosBanderas/PE.png")),
	GBP ("GBP", 1.28487, new ImageIcon("src/Assets/Images/LogosBanderas/GB.png")),
	JPY ("JPY", 0.00708422, new ImageIcon("src/Assets/Images/LogosBanderas/JP.png")),
	KRW ("KRW", 0.000785195, new ImageIcon("src/Assets/Images/LogosBanderas/KR.png")),
	BRL ("BRL", 0.211448, new ImageIcon("src/Assets/Images/LogosBanderas/BR.png")),
	ARS ("ARS", 0.00365467, new ImageIcon("src/Assets/Images/LogosBanderas/AR.png")),
	COP ("COP", 0.000255481, new ImageIcon("src/Assets/Images/LogosBanderas/co.png"))
	;
	
	private String unidad;
	private double valor;
	private ImageIcon icon;
	ImageIcon img = new ImageIcon();
	
	private ListaMonedas(String unidad, double valor, ImageIcon icon) {
		this.unidad = unidad;
		this.valor = valor;
		this.icon = icon;
	}

	@Override
	public String getUnidad() {
		// TODO Auto-generated method stub
		return this.unidad;
	}

	@Override
	public double getValor() {
		// TODO Auto-generated method stub
		return this.valor;
	}
	
	public ImageIcon getIcon() {
		// TODO Auto-generated method stub
		return this.icon;
	}
}
