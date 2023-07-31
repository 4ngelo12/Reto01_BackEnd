package com.conversor.modelo;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public interface OperacionesConversion {
	public double ObtenerValor(JComboBox<String> cb);
	public String Conversion(double valorUnidad, double valorEntrada, double valorConvertir);
	public void DevolverConversion(JTextField txtCantidad, JTextField txtMonto, JComboBox<String> cb1, JComboBox<String> cb2);
}
