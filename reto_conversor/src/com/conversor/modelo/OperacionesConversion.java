package com.conversor.modelo;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public interface OperacionesConversion {
	public void AgregarDatosCb(JComboBox<String> cb, JComboBox<String> cb2);
	public double ObtenerValor(JComboBox<String> cb);
	public String Conversion(double valorEntrada, double valorUnidad, double valorConvertir);
	public void DevolverConversion(JTextField txtCantidad, JTextField txtMonto, JComboBox<String> cb1, JComboBox<String> cb2);
}
