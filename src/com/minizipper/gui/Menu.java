package com.minizipper.gui;

import javax.swing.*;
import java.awt.*;

public class Menu {

	private JFrame frame;
	private JPanel pnl_Inicio;
	private JButton btn_Comprimir;
	private JLabel lbl_Minizipper;
	private JButton btn_Descomprimir;
	private JButton btn_Salir;

	/**
	 * Create the application.
	 */
	public Menu() {
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
		
		pnl_Inicio = new JPanel();
		frame.getContentPane().add(pnl_Inicio, "name_1210257421913838");
		pnl_Inicio.setLayout(null);
		
		btn_Comprimir = new JButton("Comprimir");
		btn_Comprimir.setBounds(60, 69, 125, 23);
		pnl_Inicio.add(btn_Comprimir);
		
		lbl_Minizipper = new JLabel("MiniZipper");
		lbl_Minizipper.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_Minizipper.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Minizipper.setBounds(10, 11, 218, 48);
		pnl_Inicio.add(lbl_Minizipper);
		
		btn_Descomprimir = new JButton("Descomprimir");
		btn_Descomprimir.setBounds(60, 103, 125, 23);
		pnl_Inicio.add(btn_Descomprimir);
		
		btn_Salir = new JButton("Salir");
		btn_Salir.setBounds(154, 159, 74, 23);
		pnl_Inicio.add(btn_Salir);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getPnl_Inicio() {
		return pnl_Inicio;
	}

	public void setPnl_Inicio(JPanel pnl_Inicio) {
		this.pnl_Inicio = pnl_Inicio;
	}

	public JButton getBtn_Comprimir() {
		return btn_Comprimir;
	}

	public void setBtn_Comprimir(JButton btn_Comprimir) {
		this.btn_Comprimir = btn_Comprimir;
	}

	public JLabel getLbl_Minizipper() {
		return lbl_Minizipper;
	}

	public void setLbl_Minizipper(JLabel lbl_Minizipper) {
		this.lbl_Minizipper = lbl_Minizipper;
	}

	public JButton getBtn_Descomprimir() {
		return btn_Descomprimir;
	}

	public void setBtn_Descomprimir(JButton btn_Descomprimir) {
		this.btn_Descomprimir = btn_Descomprimir;
	}

	public JButton getBtn_Salir() {
		return btn_Salir;
	}

	public void setBtn_Salir(JButton btn_Salir) {
		this.btn_Salir = btn_Salir;
	}
}
