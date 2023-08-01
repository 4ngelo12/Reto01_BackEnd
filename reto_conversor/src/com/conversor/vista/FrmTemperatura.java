package com.conversor.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.conversor.controlador.TemperaturaController;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class FrmTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtConvertido;
	private JLabel lblNewLabel = new JLabel("Conversor de Temperaturas");
	private JLabel lblNewLabel_1 = new JLabel("Cantidad");
	private JLabel lblNewLabel_1_1 = new JLabel("De");
	private JLabel lblNewLabel_1_1_1 = new JLabel("A");
	private JComboBox<String> cbTemOrigen = new JComboBox<String>();
	private JComboBox<String> cbTemDestino = new JComboBox<String>();
	private JButton btnHome = new JButton("Home");
	private TemperaturaController TC = new TemperaturaController();
	
	/**
	 * Create the frame.
	 */
	public FrmTemperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 234, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		//Iniciar Componentes
		initComponents();
		
		TC.AgregarDatosCb(cbTemOrigen, cbTemDestino);
		TC.DevolverConversion(txtCantidad, txtConvertido, cbTemOrigen, cbTemDestino);
		
		//Cargar Eventos
		CargarEventos();
		
		this.setLocationRelativeTo(null);
		this.setTitle("Conversor de Temperatura");
	}
	
	private void initComponents() {
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(255, 233, 179));
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setBackground(new Color(190, 135, 89));
		lblNewLabel.setForeground(new Color(255, 233, 179));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
		
		txtCantidad = new JTextField();
		txtCantidad.setText("1");
		txtCantidad.setFont(new Font("SimSun", Font.PLAIN, 18));
		txtCantidad.setColumns(10);
		
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		
		cbTemOrigen.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		
		lblNewLabel_1_1.setFont(new Font("Bodoni MT", Font.PLAIN, 26));
		
		cbTemDestino.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		
		lblNewLabel_1_1_1.setFont(new Font("Bodoni MT", Font.PLAIN, 26));
		
		btnHome.setVerticalAlignment(SwingConstants.BOTTOM);
		btnHome.setForeground(Color.BLACK);
		btnHome.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		btnHome.setFocusPainted(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		ImageIcon image = new ImageIcon("src/Assets/Images/LogosInicio/logo_home.png");
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(50, 50, DO_NOTHING_ON_CLOSE));
		btnHome.setIcon(icon);
		
		JLabel lblNewLabel_1_2 = new JLabel("Conversión");
		lblNewLabel_1_2.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		
		txtConvertido = new JTextField();
		txtConvertido.setEditable(false);
		txtConvertido.setFont(new Font("SimSun", Font.PLAIN, 18));
		txtConvertido.setColumns(10);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(125)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(209, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtConvertido, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
							.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(106))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(cbTemOrigen, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(111)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbTemDestino, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(140))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
							.addComponent(cbTemOrigen, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
						.addComponent(cbTemDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtConvertido, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(30))))
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
		
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

		        boolean numeros = key >= 48 && key <= 57 || key == 45;
				boolean dotValidation = txtCantidad.getText().contains(".");
				    
				if (!numeros && dotValidation)
				{
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				TC.DevolverConversion(txtCantidad, txtConvertido, cbTemOrigen, cbTemDestino);
			}
		});
		
		cbTemOrigen.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					TC.DevolverConversion(txtCantidad, txtConvertido, cbTemOrigen, cbTemDestino);
				}
			}
		});
		
		cbTemDestino.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					TC.DevolverConversion(txtCantidad, txtConvertido, cbTemOrigen, cbTemDestino);
				}
			}
		});
	}
}
