package com.minizipper.gui;

import java.awt.*;
import javax.swing.*;

public class VentanaComThread {

    private JDialog frame;
    private JPanel panel;
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
        frame = new JDialog();
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

        txtCurrentFile = new JLabel("");
        txtCurrentFile.setFont(new Font("Tahoma", Font.PLAIN, 10));
        txtCurrentFile.setBounds(10, 61, 364, 13);
        panel.add(txtCurrentFile);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.WHITE);
        btnCancelar.setBounds(285, 127, 89, 23);
        panel.add(btnCancelar);
    }

    public JDialog getFrame() {
        return frame;
    }

    public void setFrame(JDialog frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
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
