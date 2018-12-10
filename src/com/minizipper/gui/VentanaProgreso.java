package com.minizipper.gui;

import com.minizipper.zipper.Zipper;

import java.awt.*;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import javax.swing.*;

public class VentanaProgreso {

    private JFrame frame;
    private JPanel panel;
    private JLabel txtSize;
    private  JLabel txtSpeed;
    private JProgressBar ProBar;
    private JLabel txtCurrentFile;
    private JButton btnCancelar;

    public VentanaProgreso() {
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

        ProBar = new JProgressBar();
        ProBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        ProBar.setBackground(new Color(255, 255, 255));
        ProBar.setValue(0);
        ProBar.setStringPainted(true);
        ProBar.setForeground(SystemColor.textHighlight);
        ProBar.setBounds(10, 79, 364, 29);
        panel.add(ProBar);

        txtSize = new JLabel("");
        txtSize.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtSize.setBounds(10, 11, 180, 23);
        panel.add(txtSize);

        txtSpeed = new JLabel("");
        txtSpeed.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtSpeed.setBounds(224, 11, 150, 23);
        panel.add(txtSpeed);

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

    public JLabel getTxtSize() {
        return txtSize;
    }

    public void setTxtSize(JLabel txtSize) {
        this.txtSize = txtSize;
    }

    public JLabel getTxtSpeed() {
        return txtSpeed;
    }

    public void setTxtSpeed(JLabel txtSpeed) {
        this.txtSpeed = txtSpeed;
    }

    public JProgressBar getProBar() {
        return ProBar;
    }

    public void setProBar(JProgressBar proBar) {
        ProBar = proBar;
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

    public String toSizeUnit(long length, boolean hasUnit){

        double size = (double)length/1024;
        String[] unit = {" Kb", " Mb", " Gb"};

        int x=0;
        for(;size/1024>1; x++){
            size = size/1024;
        }

        return hasUnit ? (new DecimalFormat("#.##").format(size) + unit[x]) : (new DecimalFormat("#.##").format(size));
    }

    public void updateGUI(long procesedSize, long totalSize, long speedSize){
        this.ProBar.setValue((int)((procesedSize*100)/ totalSize));
        this.txtSize.setText("Total: \t"+toSizeUnit(procesedSize, true)+" / "+toSizeUnit(totalSize, true));
        this.txtSpeed.setText("Velocidad: \t"+toSizeUnit(speedSize, true)+"/s");
    }

    public long[] refreshGUI(Zipper parent){
        long[] values = {parent.getSpeedSize(), parent.getReaded(), parent.getTime()}; //SpeedSize, Readed, Time

        if ((new Timestamp(System.currentTimeMillis()).getTime() / 1000) != parent.getTime() / 10) {
            values[0] = (parent.getSpeedSize() + parent.getReaded()) / 2;
            values[1] = 0;
        }

        if ((new Timestamp(System.currentTimeMillis()).getTime() / 100) != parent.getTime()) {
            updateGUI(parent.getProcesedSize(), parent.getTotalSize(), parent.getSpeedSize());
            values[2] = new Timestamp(System.currentTimeMillis()).getTime() / 100;
        }

        return values;
    }
}
