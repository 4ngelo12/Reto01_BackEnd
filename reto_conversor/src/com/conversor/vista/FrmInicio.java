package com.conversor.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.LayoutStyle.ComponentPlacement;

public class FrmInicio extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitulo = new JLabel("Selecciona el Tipo de Conversor");
	private JButton btnMoneda = new JButton("Convertir Divisas");
	private JButton btnTemperatura = new JButton("Convertir Temperatura");
	private JButton btnRepositorio = new JButton("4ngelo12");
	private final JLabel lblNewLabel = new JLabel("Desarollado por:");

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
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 417);
		
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
		ImageIcon image = new ImageIcon(FrmInicio.class.getResource("/Assets/Images/LogosInicio/logos_divisas.png"));
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(125, 125, DO_NOTHING_ON_CLOSE));
		btnMoneda.setIcon(icon);
		
		btnTemperatura.setVerticalAlignment(SwingConstants.BOTTOM);
		btnTemperatura.setForeground(Color.BLACK);
		btnTemperatura.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnTemperatura.setFocusPainted(false);
		btnTemperatura.setContentAreaFilled(false);
		btnTemperatura.setBorderPainted(false);
		ImageIcon imageTemp = new ImageIcon(FrmInicio.class.getResource("/Assets/Images/LogosInicio/logo_temperatura.png"));
		Icon iconTemp = new ImageIcon(imageTemp.getImage().getScaledInstance(125, 125, DO_NOTHING_ON_CLOSE));
		btnTemperatura.setIcon(iconTemp);
		
		btnRepositorio.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		btnRepositorio.setFocusPainted(false);
		btnRepositorio.setContentAreaFilled(false);
		btnRepositorio.setBorderPainted(false);
		ImageIcon imageGit = new ImageIcon(FrmInicio.class.getResource("/Assets/Images/LogosInicio/logo_github.png"));
		Icon iconGit = new ImageIcon(imageGit.getImage().getScaledInstance(35, 35, DO_NOTHING_ON_CLOSE));
		btnRepositorio.setIcon(iconGit);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(btnMoneda, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(btnTemperatura, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(236)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRepositorio, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(236, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnTemperatura, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMoneda, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRepositorio, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap())
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
		
		btnRepositorio.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				btnRepositorio.setForeground(new Color(139, 90, 43));
            }
			
            @Override
            public void mouseExited(MouseEvent e) {
            	btnRepositorio.setForeground((Color.BLACK));
            }
            
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/4ngelo12/Reto01_BackEnd.git"));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
	}
}
