package com.conversor.modelo;

import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Interfaz que contiene las operaciones que se utilizaran en el controlador para realizar la conversión
 * 
 * @version 1.0
 * @author Angelo Casapaico
 */
public interface OperacionesConversion {
	/**
	 * Método para agregar datos dentro los JComboBox
	 * @param cb Instancia de un JComboBox con datos del tipo String
	 * @param cb2 Instancia de un JComboBox con datos del tipo String
	 */
	public void AgregarDatosCb(JComboBox<String> cb, JComboBox<String> cb2);
	
	/**
	 * Método para devolver el valor que se encuentra dentro del JComboBox 
	 * según la posición seleccionada
	 * 
	 * @param cb Instancia de un JComboBox con datos del tipo String
	 * @return
	 */
	public double ObtenerValor(JComboBox<String> cb);
	
	/**
	 * Método para realizar las operaciones de conversión de las unidades
	 * 
	 * @param valorEntrada El valor de entrada
	 * @param valorUnidad El valor de la unidad de origen
	 * @param valorConvertir El valor de la unidad que se desea obtener
	 * @return Regresa el valor de la conversión
	 */
	public String Conversion(double valorEntrada, double valorUnidad, double valorConvertir);
	
	/**
	 * Método para devolver el valor de la conversión
	 * 
	 * @param txtCantidad JTextField donde se obtiene el valor que se desea convertir desde la unidad de origen
	 * @param txtMonto JTextField donde se coloca el monto convertido a la unidad deseada
	 * @param cb1 JComboBox con valores String donde se obtiene la unidad de origen
	 * @param cb2 JComboBox con valores String donde se obtiene la unidad que se desea obtener
	 */
	public void DevolverConversion(JTextField txtCantidad, JTextField txtMonto, JComboBox<String> cb1, JComboBox<String> cb2);
	
	/**
	 * Método para remover caracteres invalidos que se han ingresado
	 * 
	 * @param str Cadena de caracteres que se obtiene de un JTextField donde se ingresa el valor a convertir
	 * @return Devuelve una cadena con los valores invalidos removidos
	 */
	public String RemoveLastChar(String str);
	
	/**
	 * Método para cambiar las unidades que se desean convertir. Ejm: pasar de USD -> EUR a EUR -> USD
	 * 
	 * @param cb1 JComboBox con valores String donde se obtiene la unidad que se desea convertir
	 * @param cb2 JComboBox con valores String donde se obtiene la unidad que se desea obtener
	 */
	public void IntercambiarValor(JComboBox<String> cb1, JComboBox<String> cb2);
	
	/**
	 * Método que contiene las validaciones para ingresar el valor que se desea convertir y
	 * que devulve los resultados a la interfaz del usuario
	 * 
	 * @param txtCantidad JTextField donde se ingresa el valor que se desea convertir
	 * @param e KeyEvent para obtener los valores que se pueden utilizar en el JTextField anterior
	 * @param txtMonto JTextField donde se ingresa el valor de la conversión realizada
	 * @param cbOrigen  JComboBox donde se obtiene la unidad que se desea convertir
	 * @param cbDestino JComboBox donde se obtiene la unidad que se desea obtener
	 */
	public void Validacion(JTextField txtCantidad, KeyEvent e, JTextField txtMonto, JComboBox<String> cbOrigen, 
			JComboBox<String> cbDestino);
}
