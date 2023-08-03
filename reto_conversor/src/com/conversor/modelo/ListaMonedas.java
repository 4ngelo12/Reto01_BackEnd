package com.conversor.modelo;

import javax.swing.ImageIcon;

public enum ListaMonedas implements MetodosUnidades{
	USD ("USD", 1, Banderas.iconUS),
	EUR ("EUR", 1.10156, Banderas.iconEUR),
	MXN ("MXN", 0.0599273, Banderas.iconMXN),
	PEN ("PEN", 0.28, Banderas.iconPEN),
	GBP ("GBP", 1.28487, Banderas.iconGBP),
	JPY ("JPY", 0.00708422, Banderas.iconJPY),
	KRW ("KRW", 0.000785195, Banderas.iconKRW),
	BRL ("BRL", 0.211448, Banderas.iconBRL),
	ARS ("ARS", 0.00365467, Banderas.iconARS),
	COP ("COP", 0.000255481, Banderas.iconCOP)
	;
	
	private String unidad;
	private double valor;
	private ImageIcon icon;
	
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
	
	/**
	 * Método para obener el icono de la divisa seleccionada
	 * @return Devuelve el icono de la divisa
	 */
	public ImageIcon getIcon() {
		// TODO Auto-generated method stub
		return this.icon;
	}
}
