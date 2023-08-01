package com.conversor.modelo;

public enum ListaTemperatura implements MetodosUnidades{
	CELSIUS ("°C", "Celcius", 0),
	FAHRENHEIT ("°F", "Fahrenheit", 1),
	KELVIN ("K", "Kelvin", 2);
	
	private String unidad;
	private String nombreUnidad;
	private double valor;

	private ListaTemperatura (String unidad, String nombreUnidad, double valor) {
		this.unidad = unidad;
		this.nombreUnidad = nombreUnidad;
		this.valor = valor;
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
	
	public String getNombreUnidad() {
		return this.nombreUnidad;
	}

}
