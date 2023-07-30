package com.conversor.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FrmInicio extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitulo = new JLabel("Selecciona el Tipo de Conversor");
	private JButton btnMoneda = new JButton("Convertir Divisas");
	private JButton btnTemperatura = new JButton("Convertir Temperatura");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInicio frame = new FrmInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 400);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 234, 220));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		//Iniciar Componentes
		initComponents();
		
		//Cargar Eventos
		CargarEventos();
		
		this.setLocationRelativeTo(null);
		this.setTitle("Conversor Inicio");
	}
	
	private void initComponents() {
		lblTitulo.setForeground(new Color(255, 233, 179));
		lblTitulo.setBackground(new Color(190, 135, 89));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		//Label
		lblTitulo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		lblTitulo.setOpaque(true);
		
		//Botones
		btnMoneda.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnMoneda.setForeground(Color.BLACK);
		btnMoneda.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMoneda.setContentAreaFilled(false);
		btnMoneda.setFocusPainted(false);
		btnMoneda.setBorderPainted(false);
		ImageIcon image = new ImageIcon("src/Assets/Images/LogosInicio/logos_divisas.png");
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(125, 125, DO_NOTHING_ON_CLOSE));
		btnMoneda.setIcon(icon);
		
		btnTemperatura.setVerticalAlignment(SwingConstants.BOTTOM);
		btnTemperatura.setForeground(Color.BLACK);
		btnTemperatura.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnTemperatura.setFocusPainted(false);
		btnTemperatura.setContentAreaFilled(false);
		btnTemperatura.setBorderPainted(false);
		ImageIcon imageTemp = new ImageIcon("src/Assets/Images/LogosInicio/logo_temperatura.png");
		Icon iconTemp = new ImageIcon(imageTemp.getImage().getScaledInstance(125, 125, DO_NOTHING_ON_CLOSE));
		btnTemperatura.setIcon(iconTemp);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(btnMoneda, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(btnTemperatura, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMoneda, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTemperatura, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void CargarEventos() {
		btnMoneda.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				btnMoneda.setForeground(new Color(139, 90, 43));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	btnMoneda.setForeground((Color.BLACK));
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmMonedas frmMoneda = new FrmMonedas();
				
				frmMoneda.setVisible(true);
				
				dispose();
			}
		});
		
		btnTemperatura.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				btnTemperatura.setForeground(new Color(139, 90, 43));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	btnTemperatura.setForeground((Color.BLACK));
            }
            
            @Override
			public void mouseClicked(MouseEvent e) {
				FrmTemperatura frmTemperatura = new FrmTemperatura();
				
				frmTemperatura.setVisible(true);
				
				dispose();
			}
		});
	}
	
	
}
