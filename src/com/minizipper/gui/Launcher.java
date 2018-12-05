package com.minizipper.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher {

    private static Inicio window;
    private static VentanaCom ventanaCom;
    private static VentanaDes ventanaDes;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    window = new Inicio();
                    window.getFrame().setVisible(true);
                    setActionListeners();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void setActionListeners(){

        window.getBtn_Comprimir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCom = new VentanaCom(window.getFrame());
                setComActionListeners();
                ventanaCom.getFrame().setVisible(true);
            }
        });

        window.getBtn_Descomprimir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaDes = new VentanaDes(window.getFrame());
                setDesActionListeners();
                ventanaDes.getFrame().setVisible(true);
            }
        });

        window.getBtn_Salir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void setComActionListeners(){

        ventanaCom.getBtn_Examinar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("alfo");
                ventanaCom.setPath(SeleccionarArchivo.sacarPathDirectorio());
                ventanaCom.getTxt_Path().setText(ventanaCom.getPath());
            }
        });

        ventanaCom.getBtn_Comprimir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        ventanaCom.getBtn_Limpiar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCom.getTxt_Path().setText("");
            }
        });

        ventanaCom.getBtn_Atras().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCom.getFrame().dispose();
            }
        });

        ventanaCom.getBtn_Salir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void setDesActionListeners(){

        ventanaDes.getBtn_Examinar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = SeleccionarArchivo.sacarPathArchivo();
                ventanaDes.setPath(path);
                ventanaDes.getTxt_Path().setText(ventanaDes.getPath());
            }
        });

        ventanaDes.getBtn_Descomprimir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        ventanaDes.getBtnLimpiar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaDes.getTxt_Path().setText("");
            }
        });

        ventanaDes.getBtn_Atras().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaDes.getFrame().dispose();
            }
        });

        ventanaDes.getBtn_Salir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}