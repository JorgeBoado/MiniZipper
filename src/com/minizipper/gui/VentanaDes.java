package com.minizipper.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDes {

	private JFrame frame;
	private JTextField txt_Path;
	private String path;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDes window = new VentanaDes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaDes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("MiniZipper");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel pnl_Des = new JPanel();
		frame.getContentPane().add(pnl_Des, "name_1212786545314710");
		pnl_Des.setLayout(null);
		
		JLabel lbl_Archivo = new JLabel("Archivo:");
		lbl_Archivo.setBounds(10, 45, 67, 14);
		pnl_Des.add(lbl_Archivo);
		
		txt_Path = new JTextField();
		txt_Path.setBounds(10, 70, 359, 20);
		pnl_Des.add(txt_Path);
		txt_Path.setColumns(10);
		
		JButton btn_Examinar = new JButton("...");
		btn_Examinar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				path = SeleccionarArchivo.sacarPathDirectorio();
				txt_Path.setText(path);
			}
		});
		btn_Examinar.setBounds(379, 69, 45, 23);
		pnl_Des.add(btn_Examinar);
		
		JButton btn_Atras = new JButton("Atras");
		btn_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inicio.init();
				frame.dispose();
			}
		});
		btn_Atras.setBounds(10, 11, 67, 23);
		pnl_Des.add(btn_Atras);
		
		JButton btn_Salir = new JButton("Salir");
		btn_Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btn_Salir.setBounds(350, 228, 74, 23);
		pnl_Des.add(btn_Salir);
		
		JButton btn_Descomprimir = new JButton("Descomprimir");
		btn_Descomprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_Descomprimir.setBounds(118, 228, 125, 23);
		pnl_Des.add(btn_Descomprimir);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_Path.setText("");
			}
		});
		btnLimpiar.setBounds(253, 228, 87, 23);
		pnl_Des.add(btnLimpiar);
	}

}
