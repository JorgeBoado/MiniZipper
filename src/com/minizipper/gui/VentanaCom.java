package com.minizipper.gui;

import java.awt.*;

import javax.swing.*;

public class VentanaCom {

	private JFrame parentFrame;
	private JDialog frame;
	private JTextField txt_Path;
	private String path;
	private JPanel pnl_Com;
	private JLabel lbl_Archivo;
	private JButton btn_Examinar;
	private JButton btn_Atras;
	private JButton btn_Salir;
	private JButton btn_Comprimir;
	private JButton btn_Limpiar;


	public VentanaCom(JFrame parent) {
		this.parentFrame = parent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		frame = parentFrame!=null ? new JDialog(parentFrame, "", Dialog.ModalityType.APPLICATION_MODAL) : new JDialog();

		frame.setTitle("MiniZipper");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		pnl_Com = new JPanel();
		frame.getContentPane().add(pnl_Com, "name_1212536457471857");
		pnl_Com.setLayout(null);
		
		lbl_Archivo = new JLabel("Archivo:");
		lbl_Archivo.setBounds(10, 45, 67, 14);
		pnl_Com.add(lbl_Archivo);
		
		txt_Path = new JTextField();
		txt_Path.setBounds(10, 70, 359, 20);
		pnl_Com.add(txt_Path);
		txt_Path.setColumns(10);
		
		btn_Examinar = new JButton("...");
		btn_Examinar.setBounds(379, 69, 45, 23);
		pnl_Com.add(btn_Examinar);
		
		btn_Atras = new JButton("Atras");

		btn_Atras.setBounds(10, 11, 67, 23);
		pnl_Com.add(btn_Atras);
		
		btn_Salir = new JButton("Salir");

		btn_Salir.setBounds(350, 228, 74, 23);
		pnl_Com.add(btn_Salir);
		
		btn_Comprimir = new JButton("Comprimir");

		btn_Comprimir.setBounds(118, 228, 125, 23);
		pnl_Com.add(btn_Comprimir);
		
		btn_Limpiar = new JButton("Limpiar");
		btn_Limpiar.setBounds(253, 228, 87, 23);
		pnl_Com.add(btn_Limpiar);
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

	public JPanel getPnl_Com() {
		return pnl_Com;
	}

	public void setPnl_Com(JPanel pnl_Com) {
		this.pnl_Com = pnl_Com;
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

	public JButton getBtn_Comprimir() {
		return btn_Comprimir;
	}

	public void setBtn_Comprimir(JButton btn_Comprimir) {
		this.btn_Comprimir = btn_Comprimir;
	}

	public JButton getBtn_Limpiar() {
		return btn_Limpiar;
	}

	public void setBtn_Limpiar(JButton btn_Limpiar) {
		this.btn_Limpiar = btn_Limpiar;
	}
}
