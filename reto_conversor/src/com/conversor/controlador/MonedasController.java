package com.conversor.controlador;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.conversor.modelo.ListaMonedas;
import com.conversor.modelo.OperacionesConversion;

public class MonedasController implements OperacionesConversion{
	@Override
	public void AgregarDatosCb(JComboBox<String> cb, JComboBox<String> cb2) {
		for (var lstMoneda: ListaMonedas.values()) {
			cb.addItem(lstMoneda.getUnidad());
			cb2.addItem(lstMoneda.getUnidad());
		}
	}
	
	@Override
	public double ObtenerValor(JComboBox<String> cb) {
		int posicion = cb.getSelectedIndex();
		ArrayList<Double> valoresUnidad = new ArrayList<Double>();
		
		for (var lstMoneda: ListaMonedas.values()) {
			valoresUnidad.add(lstMoneda.getValor());
		}
		
		return valoresUnidad.get(posicion);
	}
	
	@Override
	public String Conversion(double valorEntrada, double valorUnidad, double valorConvertir) {
		BigDecimal Unidad = new BigDecimal(valorUnidad);
		BigDecimal Entrada = new BigDecimal(valorEntrada);
		BigDecimal valorC = new BigDecimal(valorConvertir);

		BigDecimal multiplicacion = Unidad.multiply(Entrada);
		BigDecimal conversion = multiplicacion.divide(valorC, 4, RoundingMode.FLOOR);
		
		return conversion.doubleValue() != 0 ? conversion.toString() : "0";
	}
	
	@Override
	public void DevolverConversion(JTextField txtCantidad, JTextField txtMonto, JComboBox<String> cb1, JComboBox<String> cb2) {
		double valorOrigenTxt, valorOrigenCb, valorDestionCb = 0;
		
		valorOrigenTxt = !txtCantidad.getText().isEmpty() ? Double.parseDouble(txtCantidad.getText()) : 0;
    	valorOrigenCb = ObtenerValor(cb1);
    	valorDestionCb = ObtenerValor(cb2);
    	
    	txtMonto.setText(Conversion(valorOrigenTxt, valorOrigenCb, valorDestionCb));
	}
	
	public void AgregarDatosCb(JComboBox<String> cb, JComboBox<String> cb2, Hashtable<Object, ImageIcon> hm) {
		for (var lstMoneda: ListaMonedas.values()) {
			cb.addItem(lstMoneda.getUnidad());
			cb2.addItem(lstMoneda.getUnidad());
			hm.put(lstMoneda.getUnidad(), lstMoneda.getIcon());
		}
		
		RenderIcon render = new RenderIcon(hm);
		cb.setRenderer(render);
		cb2.setRenderer(render);
		cb2.setSelectedIndex(1);
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
	
	public void Validacion(JTextField txtCantidad, KeyEvent e, JTextField txtMonto, JComboBox<String> cbDivOrigen, 
			JComboBox<String> cbDivDestino) {
		int key = e.getKeyChar();

        boolean numeros = (key >= 48 && key <= 57) || 
        		key == 46 || e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE 
        		|| e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT;

        int count = 0;
        
        for (int i = 0; i < txtCantidad.getText().length(); i++) {
        	if (String.valueOf(txtCantidad.getText().charAt(i)).contains(".")) {
        		count++;
        	}
        }
        
		if (!numeros || count > 1)
		{
			JOptionPane.showMessageDialog(null, "El valor ingresado no es valido", "Advertencia", 2);
			txtCantidad.setText(RemoveLastChar(txtCantidad.getText()));
		} 
		
		DevolverConversion(txtCantidad, txtMonto, cbDivOrigen, cbDivDestino);	
	}
}