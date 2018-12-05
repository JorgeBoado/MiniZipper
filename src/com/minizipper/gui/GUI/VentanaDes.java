package com.minizipper.gui.GUI;

import javax.swing.*;
import java.awt.*;

public class VentanaDes {

	private JFrame parentFrame;
	private JDialog frame;
	private JTextField txt_Path;
	private String path;
	private JPanel pnl_Des;
	private JLabel lbl_Archivo;
	private JButton btn_Examinar;
	private JButton btn_Atras;
	private JButton btn_Salir;
	private JButton btn_Descomprimir;
	private JButton btnLimpiar;


	public VentanaDes(JFrame parent) {
		parentFrame = parent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = parentFrame!=null ? new JDialog(parentFrame, "", Dialog.ModalityType.APPLICATION_MODAL) : new JDialog();
		frame.setTitle("MiniZipper");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		pnl_Des = new JPanel();
		frame.getContentPane().add(pnl_Des, "name_1212786545314710");
		pnl_Des.setLayout(null);
		
		lbl_Archivo = new JLabel("Archivo:");
		lbl_Archivo.setBounds(10, 45, 67, 14);
		pnl_Des.add(lbl_Archivo);
		
		txt_Path = new JTextField();
		txt_Path.setBounds(10, 70, 359, 20);
		pnl_Des.add(txt_Path);
		txt_Path.setColumns(10);
		
		btn_Examinar = new JButton("...");
		btn_Examinar.setBounds(379, 69, 45, 23);
		pnl_Des.add(btn_Examinar);
		
		btn_Atras = new JButton("Atras");

		btn_Atras.setBounds(10, 11, 67, 23);
		pnl_Des.add(btn_Atras);
		
		btn_Salir = new JButton("Salir");

		btn_Salir.setBounds(350, 228, 74, 23);
		pnl_Des.add(btn_Salir);
		
		btn_Descomprimir = new JButton("Descomprimir");

		btn_Descomprimir.setBounds(118, 228, 125, 23);
		pnl_Des.add(btn_Descomprimir);
		
		btnLimpiar = new JButton("Limpiar");

		btnLimpiar.setBounds(253, 228, 87, 23);
		pnl_Des.add(btnLimpiar);
	}

	public JFrame getParentFrame() {
		return parentFrame;
	}

	public void setParentFrame(JFrame parentFrame) {
		this.parentFrame = parentFrame;
	}

	public JDialog getFrame() {
		return frame;
	}

	public void setFrame(JDialog frame) {
		this.frame = frame;
	}

	public JTextField getTxt_Path() {
		return txt_Path;
	}

	public void setTxt_Path(JTextField txt_Path) {
		this.txt_Path = txt_Path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public JPanel getPnl_Des() {
		return pnl_Des;
	}

	public void setPnl_Des(JPanel pnl_Des) {
		this.pnl_Des = pnl_Des;
	}

	public JLabel getLbl_Archivo() {
		return lbl_Archivo;
	}

	public void setLbl_Archivo(JLabel lbl_Archivo) {
		this.lbl_Archivo = lbl_Archivo;
	}

	public JButton getBtn_Examinar() {
		return btn_Examinar;
	}

	public void setBtn_Examinar(JButton btn_Examinar) {
		this.btn_Examinar = btn_Examinar;
	}

	public JButton getBtn_Atras() {
		return btn_Atras;
	}

	public void setBtn_Atras(JButton btn_Atras) {
		this.btn_Atras = btn_Atras;
	}

	public JButton getBtn_Salir() {
		return btn_Salir;
	}

	public void setBtn_Salir(JButton btn_Salir) {
		this.btn_Salir = btn_Salir;
	}

	public JButton getBtn_Descomprimir() {
		return btn_Descomprimir;
	}

	public void setBtn_Descomprimir(JButton btn_Descomprimir) {
		this.btn_Descomprimir = btn_Descomprimir;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}
}
