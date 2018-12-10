package com.minizipper.gui;

import com.minizipper.unzip.UnZip;
import com.minizipper.zip.Zip;

import java.awt.*;

public class Launcher {

    private static Inicio window;
    private static VentanaCom ventanaCom;
    private static VentanaDes ventanaDes;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                window = new Inicio();
                window.getFrame().setVisible(true);
                setActionListeners();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void setActionListeners(){

        window.getBtn_Comprimir().addActionListener(e -> {
            ventanaCom = new VentanaCom(window.getFrame());
            setComActionListeners();
            ventanaCom.getFrame().setVisible(true);
        });

        window.getBtn_Descomprimir().addActionListener(e -> {
            ventanaDes = new VentanaDes(window.getFrame());
            setDesActionListeners();
            ventanaDes.getFrame().setVisible(true);
        });

        window.getBtn_Salir().addActionListener(e -> System.exit(0));
    }

    public static void setComActionListeners(){

        ventanaCom.getBtn_Examinar().addActionListener(e -> {
            ventanaCom.setPath(SeleccionarArchivo.sacarPathDirectorio());
            ventanaCom.getTxt_Path().setText(ventanaCom.getPath());
        });

        ventanaCom.getBtn_Comprimir().addActionListener(e -> {
            Zip.zip(ventanaCom.getPath());
            ventanaCom.getFrame().dispose();
        });

        ventanaCom.getBtn_Limpiar().addActionListener(e -> ventanaCom.getTxt_Path().setText(""));

        ventanaCom.getBtn_Atras().addActionListener(e -> ventanaCom.getFrame().dispose());

        ventanaCom.getBtn_Salir().addActionListener(e -> System.exit(0));
    }

    public static void setDesActionListeners(){

        ventanaDes.getBtn_Examinar().addActionListener(e -> {
            String path = SeleccionarArchivo.sacarPathArchivo();
            ventanaDes.setPath(path);
            ventanaDes.getTxt_Path().setText(ventanaDes.getPath());
        });

        ventanaDes.getBtn_Descomprimir().addActionListener(e -> {
            UnZip.unZip(ventanaDes.getPath());
            ventanaDes.getFrame().dispose();
        });

        ventanaDes.getBtnLimpiar().addActionListener(e -> ventanaDes.getTxt_Path().setText(""));

        ventanaDes.getBtn_Atras().addActionListener(e -> ventanaDes.getFrame().dispose());

        ventanaDes.getBtn_Salir().addActionListener(e -> System.exit(0));
    }
}