package com.minizipper.gui;

import java.awt.*;
import javax.swing.*;

public class VentanaComThread {

    private JFrame frame;
    private JPanel panel;
    private JLabel txtComSize;
    private  JLabel txtComSpeed;
    private JProgressBar ComProBar;
    private JLabel txtCurrentFile;
    private JButton btnCancelar;

    public VentanaComThread() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));

        panel = new JPanel();
        frame.getContentPane().add(panel, "name_166179188499898");
        panel.setLayout(null);

        ComProBar = new JProgressBar();
        ComProBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        ComProBar.setBackground(new Color(255, 255, 255));
        ComProBar.setValue(0);
        ComProBar.setStringPainted(true);
        ComProBar.setForeground(SystemColor.textHighlight);
        ComProBar.setBounds(10, 79, 364, 29);
        panel.add(ComProBar);

        txtComSize = new JLabel("");
        txtComSize.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtComSize.setBounds(10, 11, 150, 23);
        panel.add(txtComSize);

        txtComSpeed = new JLabel("");
        txtComSpeed.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtComSpeed.setBounds(224, 11, 150, 23);
        panel.add(txtComSpeed);

        txtCurrentFile = new JLabel("");
        txtCurrentFile.setFont(new Font("Tahoma", Font.PLAIN, 10));
        txtCurrentFile.setBounds(10, 61, 364, 13);
        txtCurrentFile.setText("Buscando archivos...");
        panel.add(txtCurrentFile);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.WHITE);
        btnCancelar.setBounds(285, 127, 89, 23);
        panel.add(btnCancelar);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getTxtComSize() {
        return txtComSize;
    }

    public void setTxtComSize(JLabel txtComSize) {
        this.txtComSize = txtComSize;
    }

    public JLabel getTxtComSpeed() {
        return txtComSpeed;
    }

    public void setTxtComSpeed(JLabel txtComSpeed) {
        this.txtComSpeed = txtComSpeed;
    }

    public JProgressBar getComProBar() {
        return ComProBar;
    }

    public void setComProBar(JProgressBar comProBar) {
        ComProBar = comProBar;
    }

    public JLabel getTxtCurrentFile() {
        return txtCurrentFile;
    }

    public void setTxtCurrentFile(JLabel txtCurrentFile) {
        this.txtCurrentFile = txtCurrentFile;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }
}
