package com.conversor.controlador;

import java.awt.Component;
import java.util.Hashtable;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class RenderIcon extends DefaultListCellRenderer{
	Hashtable<Object, ImageIcon> image;
	ImageIcon mImg = new ImageIcon(new ImageIcon(this.getClass().getResource("/Assets/Images/LogosBanderas/US.png")).getImage().
			getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH));
	
	public RenderIcon (Hashtable<Object, ImageIcon> image) {
		this.image = image;
	}
	/**
	 * Método para obtener el valor de la imagen para el icono de la divisa
	 */
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		if (image.get(value) == null) {
			setIcon(mImg);
		} else {
			setIcon(image.get(value));
		}
		
		setText(value.toString());
		return this;
	}
}
