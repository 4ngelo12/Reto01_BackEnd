package com.conversor.controlador;

import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
		DecimalFormat df = new DecimalFormat("0.000");
		df.setRoundingMode(RoundingMode.HALF_UP);
		String valorEvaluacion = String.valueOf((int) valorConvertir);
		String valorDevolver = "";
		try {
			if (valorUnidad == 0) {
				switch (valorEvaluacion) {
				case "0":
					valorDevolver = String.valueOf(valorEntrada);
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
					valorDevolver = String.valueOf((valorEntrada - 32) * 5/9);
					break;
				case "1": 
					valorDevolver = String.valueOf(valorEntrada);
					break;
				case "2":
					valorDevolver = String.valueOf((valorEntrada - 32) * 5/9 + 273.15);
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
				case "2":
					valorDevolver = String.valueOf(valorEntrada);
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

	@Override
	public String RemoveLastChar(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		return str.substring(0, str.length() - 1);
	}
	
	@Override
	public void IntercambiarValor(JComboBox<String> cb1, JComboBox<String> cb2) {
		int primerValor = cb2.getSelectedIndex();
		int segundoValor = cb1.getSelectedIndex();
		
		cb1.setSelectedIndex(primerValor);
		cb2.setSelectedIndex(segundoValor);
	}
	
	@Override
	public void Validacion(JTextField txtCantidad, KeyEvent e, JTextField txtMonto, JComboBox<String> cbTemOrigen,
			JComboBox<String> cbTemDestino) {
		// TODO Auto-generated method stub
		int key = e.getKeyChar();
        boolean numeros = (key >= 48 && key <= 57) || key == 45 || 
        		key == 46 || e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE
        		||  e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT;
        boolean empieza = true;
        int dotCount = 0;
        int minusCount = 0;
        
        for (int i = 0; i < txtCantidad.getText().length(); i++) {
        	if (String.valueOf(txtCantidad.getText().charAt(i)).contains(".")) {
        		dotCount++;
        	} else if (String.valueOf(txtCantidad.getText().charAt(i)).contains("-")) {
        		minusCount++;
        		empieza = txtCantidad.getText().startsWith("-");
        	}
        }
        
		if (!numeros || (dotCount > 1 || minusCount > 1) || !empieza)
		{
			JOptionPane.showMessageDialog(null, "El valor ingresado no es valido", "Advertencia", 2);
			txtCantidad.setText(RemoveLastChar(txtCantidad.getText()));
		} 
		
		try {
			DevolverConversion(txtCantidad, txtMonto, cbTemOrigen, cbTemDestino);
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
