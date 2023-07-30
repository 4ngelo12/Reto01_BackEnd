package com.conversor.controlador;

import java.awt.Component;
import java.util.Hashtable;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class RenderIcon extends DefaultListCellRenderer{
	Hashtable<Object, ImageIcon> image;
	ImageIcon mImg = new ImageIcon(new ImageIcon(this.getClass().getResource("")).getImage().
			getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
	
	public RenderIcon (Hashtable<Object, ImageIcon> image) {
		this.image = image;
	}
	
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
