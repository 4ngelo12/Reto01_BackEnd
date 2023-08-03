package com.conversor.vista;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import com.conversor.controlador.MonedasController;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmMonedas extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtMonto;
	private JLabel lblNewLabel = new JLabel("Conversor de Divisas");
	private JLabel lblNewLabel_1 = new JLabel("Cantidad");
	private JLabel lblNewLabel_1_1 = new JLabel("De");
	private JComboBox<String> cbDivOrigen = new JComboBox<String>();
	private JComboBox<String> cbDivDestino = new JComboBox<String>();
	private JLabel lblNewLabel_1_1_1 = new JLabel("A");
	private JLabel lblNewLabel_1_2 = new JLabel("Monto:");
	private JButton btnHome = new JButton("Home");
	private MonedasController MC = new MonedasController();
	private JButton btnInvertir = new JButton("");
	
	/**
	 * Create the frame.
	 */
	public FrmMonedas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 418);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 234, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		//Colocar Componentes
		initComponents();
		
		MC.AgregarDatosCb(cbDivOrigen, cbDivDestino);
		MC.DevolverConversion(txtCantidad, txtMonto, cbDivOrigen, cbDivDestino);
		
		//Cargar Eventos
		CargarEventos();
		
		this.setLocationRelativeTo(null);
		this.setTitle("Conversor de Monedas");
	}
	
	private void initComponents() {
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(255, 233, 179));
		lblNewLabel.setBackground(new Color(190, 135, 89));
		
		//Labels
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 28));
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		lblNewLabel_1_1.setFont(new Font("Bodoni MT", Font.PLAIN, 26));

		lblNewLabel_1_1_1.setFont(new Font("Bodoni MT", Font.PLAIN, 26));
		
		lblNewLabel_1_2.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		
		//TextFields
		txtCantidad = new JTextField();
		txtCantidad.setText("1");
		txtCantidad.setFont(new Font("SimSun", Font.PLAIN, 18));
		txtCantidad.setColumns(10);
		
		txtMonto = new JTextField();
		txtMonto.setEditable(false);
		txtMonto.setFont(new Font("SimSun", Font.PLAIN, 18));
		txtMonto.setColumns(10);
		
		//ComboBox
		cbDivOrigen.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		
		cbDivDestino.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		
		//Buttons
		btnHome.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		btnHome.setForeground(Color.BLACK);
		btnHome.setVerticalAlignment(SwingConstants.BOTTOM);
		btnHome.setContentAreaFilled(false);
		btnHome.setFocusPainted(false);
		btnHome.setBorderPainted(false);
		ImageIcon image = new ImageIcon(FrmInicio.class.getResource("/Assets/Images/LogosInicio/logo_home.png"));
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(50, 50, DO_NOTHING_ON_CLOSE));
		btnHome.setIcon(icon);
		
		btnInvertir.setContentAreaFilled(false);
		btnInvertir.setFocusPainted(false);
		btnInvertir.setBorderPainted(false);
		ImageIcon imageInvertir = new ImageIcon(FrmInicio.class.getResource("/Assets/Images/LogosInicio/logo_intercambiar.png"));
		Icon iconInvertir = new ImageIcon(imageInvertir.getImage().getScaledInstance(50, 50, DO_NOTHING_ON_CLOSE));
		btnInvertir.setIcon(iconInvertir);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(97)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(124, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbDivOrigen, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnInvertir, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblNewLabel_1_1_1)
							.addGap(18)
							.addComponent(cbDivDestino, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtMonto, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
							.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(45))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(cbDivOrigen, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInvertir, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbDivDestino, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtMonto, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(42))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(34))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void CargarEventos() {
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				btnHome.setForeground(new Color(139, 90, 43));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	btnHome.setForeground((Color.BLACK));
            }
            
            @Override
			public void mouseClicked(MouseEvent e) {
				FrmInicio frmHome = new FrmInicio();
				
				frmHome.setVisible(true);
				
				dispose();
			}
		});
		
		btnInvertir.addMouseListener(new MouseAdapter() {
            @Override
			public void mouseClicked(MouseEvent e) {
            	MC.IntercambiarValor(cbDivOrigen, cbDivDestino);
			}
		});

		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {	
				MC.Validacion(txtCantidad, e, txtMonto, cbDivOrigen, cbDivDestino);			
			}
		});
		
		cbDivOrigen.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					MC.DevolverConversion(txtCantidad, txtMonto, cbDivOrigen, cbDivDestino);
				}
			}
		});
		
		cbDivDestino.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					MC.DevolverConversion(txtCantidad, txtMonto, cbDivOrigen, cbDivDestino);
				}
			}
		});
	}
}
