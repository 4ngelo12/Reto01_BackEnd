package com.conversor.controlador;

import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import com.conversor.modelo.ListaMonedas;

public class MonedasController{
	public void AgregarDatosCb(JComboBox<String> cb, JComboBox<String> cb2, Hashtable<Object, ImageIcon> hm) {
		for (var lstMoneda: ListaMonedas.values()) {
			cb.addItem(lstMoneda.getUnidad());
			cb2.addItem(lstMoneda.getUnidad());
			hm.put(lstMoneda.getUnidad(), lstMoneda.getIcon());
		}
		
		RenderIcon render = new RenderIcon(hm);
		cb.setRenderer(render);
		cb2.setRenderer(render);
	}
}
