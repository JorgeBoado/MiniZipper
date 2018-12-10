package com.minizipper.gui;

import java.io.File;

import javax.swing.JFileChooser;

public class VentanaSelector {
	
	public static String sacarPathArchivo () {
		
		File archivoSeleccionado = null;
		JFileChooser fc_Archivo = new JFileChooser();
		if (fc_Archivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			archivoSeleccionado = fc_Archivo.getSelectedFile();
		}

		if (archivoSeleccionado != null) {
			return archivoSeleccionado.getAbsolutePath();
		}
		return null;
	}
	
	public static String sacarPathDirectorio () {
		
		File archivoSeleccionado = null;
		JFileChooser fc_Archivo = new JFileChooser();
		fc_Archivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fc_Archivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			archivoSeleccionado = fc_Archivo.getSelectedFile();
		}

		if (archivoSeleccionado != null) {
			return archivoSeleccionado.getAbsolutePath();
		}
		return null;
	}
}
