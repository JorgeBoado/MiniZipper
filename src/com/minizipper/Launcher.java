package com.minizipper;

import com.minizipper.gui.Menu;
import com.minizipper.gui.VentanaCompresion;
import com.minizipper.gui.VentanaDescompresion;
import com.minizipper.gui.VentanaSelector;
import com.minizipper.unzip.UnZip;
import com.minizipper.zip.Zip;

import java.awt.*;

public class Launcher {

    private static com.minizipper.gui.Menu window;
    private static VentanaCompresion ventanaCompresion;
    private static VentanaDescompresion ventanaDescompresion;

    /**
     * Launch the application
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                window = new Menu();
                window.getFrame().setVisible(true);
                setActionListeners();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void setActionListeners(){

        window.getBtn_Comprimir().addActionListener(e -> {
            ventanaCompresion = new VentanaCompresion(window.getFrame());
            setComActionListeners();
            ventanaCompresion.getFrame().setVisible(true);
        });

        window.getBtn_Descomprimir().addActionListener(e -> {
            ventanaDescompresion = new VentanaDescompresion(window.getFrame());
            setDesActionListeners();
            ventanaDescompresion.getFrame().setVisible(true);
        });

        window.getBtn_Salir().addActionListener(e -> System.exit(0));
    }

    public static void setComActionListeners(){

        ventanaCompresion.getBtn_Examinar().addActionListener(e -> {
            ventanaCompresion.setPath(VentanaSelector.sacarPathDirectorio());
            ventanaCompresion.getTxt_Path().setText(ventanaCompresion.getPath());
        });

        ventanaCompresion.getBtn_Comprimir().addActionListener(e -> {
            Zip.zip(ventanaCompresion.getPath());
            ventanaCompresion.getFrame().dispose();
        });

        ventanaCompresion.getBtn_Limpiar().addActionListener(e -> ventanaCompresion.getTxt_Path().setText(""));

        ventanaCompresion.getBtn_Atras().addActionListener(e -> ventanaCompresion.getFrame().dispose());

        ventanaCompresion.getBtn_Salir().addActionListener(e -> System.exit(0));
    }

    public static void setDesActionListeners(){

        ventanaDescompresion.getBtn_Examinar().addActionListener(e -> {
            String path = VentanaSelector.sacarPathArchivo();
            ventanaDescompresion.setPath(path);
            ventanaDescompresion.getTxt_Path().setText(ventanaDescompresion.getPath());
        });

        ventanaDescompresion.getBtn_Descomprimir().addActionListener(e -> {
            UnZip.unZip(ventanaDescompresion.getPath());
            ventanaDescompresion.getFrame().dispose();
        });

        ventanaDescompresion.getBtnLimpiar().addActionListener(e -> ventanaDescompresion.getTxt_Path().setText(""));

        ventanaDescompresion.getBtn_Atras().addActionListener(e -> ventanaDescompresion.getFrame().dispose());

        ventanaDescompresion.getBtn_Salir().addActionListener(e -> System.exit(0));
    }
}