package com.conversor.controlador;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.conversor.modelo.ListaTemperatura;
import com.conversor.modelo.OperacionesConversion;

public class TemperaturaController implements OperacionesConversion{
	@Override
	public void AgregarDatosCb(JComboBox<String> cb, JComboBox<String> cb2) {
		for (var lstTemp: ListaTemperatura.values()) {
			cb.addItem(lstTemp.getNombreUnidad());
			cb2.addItem(lstTemp.getNombreUnidad());
		}
		cb2.setSelectedIndex(1);
	}
	
	@Override
	public double ObtenerValor(JComboBox<String> cb) {
		int posicion = cb.getSelectedIndex();
		ArrayList<Double> valoresUnidad = new ArrayList<Double>();
		
		for (var lstTemp: ListaTemperatura.values()) {
			valoresUnidad.add(lstTemp.getValor());
		}
		return valoresUnidad.get(posicion);
	}

	@Override
	public String Conversion(double valorEntrada, double valorUnidad, double valorConvertir) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		String valorEvaluacion = String.valueOf((int) valorConvertir);
		String valorDevolver = "";
		try {
			if (valorUnidad == 0) {
				switch (valorEvaluacion) {
				case "0":
					valorDevolver = "0";
					break;
				case "1": 
					valorDevolver = String.valueOf((valorEntrada * 1.8) + 32);
					break;
				case "2":
					valorDevolver = String.valueOf(valorEntrada + 273.15);
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + valorEvaluacion);
				}
			} else if (valorUnidad == 1) {
				switch (valorEvaluacion) {
				case "0": 
					valorDevolver = String.valueOf((valorEntrada - 32) * (5/9));
					break;
				case "2":
					valorDevolver = String.valueOf((valorEntrada - 32) * (5/9) + 273.15);
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + valorEvaluacion);
				}
			} else if (valorUnidad == 2) {
				switch (valorEvaluacion) {
				case "0": 
					valorDevolver = String.valueOf(valorEntrada - 273.15);
					break;
				case "1":
					valorDevolver = String.valueOf((valorEntrada - 273.15) * 1.8 + 32);
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + valorEvaluacion);
				}
			} else {
				valorDevolver = "Error";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		String formato = df.format(Double.parseDouble(valorDevolver));
		return formato;
	}

	@Override
	public void DevolverConversion(JTextField txtCantidad, JTextField txtMonto, JComboBox<String> cb1,
			JComboBox<String> cb2) {
		double valorOrigenTxt, valorOrigenCb, valorDestionCb = 0;
		
		valorOrigenTxt = !txtCantidad.getText().isEmpty() ? Double.parseDouble(txtCantidad.getText()) : 0;
    	valorOrigenCb = ObtenerValor(cb1);
    	valorDestionCb = ObtenerValor(cb2);
    	
    	txtMonto.setText(Conversion(valorOrigenTxt, valorOrigenCb, valorDestionCb));
	}
	
}
