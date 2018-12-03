package com.minizipper.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio {

	public static JFrame frame;

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("MiniZipper");
		frame.setBounds(100, 100, 254, 231);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel pnl_Inicio = new JPanel();
		frame.getContentPane().add(pnl_Inicio, "name_1210257421913838");
		pnl_Inicio.setLayout(null);
		
		JButton btn_Comprimir = new JButton("Comprimir");
		btn_Comprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCom.init();
				frame.dispose();
			}
		});
		btn_Comprimir.setBounds(60, 69, 125, 23);
		pnl_Inicio.add(btn_Comprimir);
		
		JLabel lbl_Minizipper = new JLabel("MiniZipper");
		lbl_Minizipper.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_Minizipper.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Minizipper.setBounds(10, 11, 218, 48);
		pnl_Inicio.add(lbl_Minizipper);
		
		JButton btn_Descomprimir = new JButton("Descomprimir");
		btn_Descomprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaDes.init();
				frame.dispose();
			}
		});
		btn_Descomprimir.setBounds(60, 103, 125, 23);
		pnl_Inicio.add(btn_Descomprimir);
		
		JButton btn_Salir = new JButton("Salir");
		btn_Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btn_Salir.setBounds(154, 159, 74, 23);
		pnl_Inicio.add(btn_Salir);
	}

}
