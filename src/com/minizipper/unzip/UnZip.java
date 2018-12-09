package com.minizipper.unzip;

import com.minizipper.gui.VentanaThread;
import com.minizipper.zipper.Zipper;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip extends Zipper {
    private String inputZipFile;
    private String outputFolder;
    private VentanaThread window;

    private UnZip(String source) {
        inputZipFile = source;
        outputFolder = source.substring(0, source.lastIndexOf("\\"));
    }

    public static void unZip(String source) {
        UnZip unZip = new UnZip(source);
        unZip.start();
    }

    @Override
    public void run() {
        window = new VentanaThread();
        setListeners();
        window.getFrame().setVisible(true);
        setTotalSize(new File(inputZipFile).length());
        unZipIt(inputZipFile, outputFolder);
    }

    private void setListeners(){

        window.getBtnCancelar().addActionListener(e -> {
            int confirm;
            setWait(true);
            confirm = JOptionPane.showConfirmDialog (window.getFrame(), "¿Estas seguro de que deseas cancelar la descompresion?","Cancelar",JOptionPane.YES_NO_OPTION);
            if(confirm==0){
                setCancel(true);
                window.getFrame().dispose();
            }
            setWait(false);
        });
    }

    private void unZipIt(String zipFile, String outputFolder) {

        setTime(new Timestamp(System.currentTimeMillis()).getTime() / 100);

        byte[] buffer = new byte[1024];

        try {
            //create output directory is not exists
            File folder = new File(outputFolder);
            if (!folder.exists()) {
                folder.mkdir();
            }

            //get the zip file content
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
            //get the zipped file list entry
            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {

                while (isWait()) {
                    System.out.print("");
                }
                if(isCancel()) {break;}

                String fileName = ze.getName();
                File newFile = new File(outputFolder + File.separator + fileName);

                //System.out.println("file unzip : " + newFile.getAbsoluteFile());
                window.getTxtCurrentFile().setText(newFile.getAbsolutePath());

                //create all non exists folders
                //else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();

                FileOutputStream fos = new FileOutputStream(newFile);

                //TODO: Arreglar problema de diferencia de tamaños debido a la compresion, o modificar GUI

                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);

                    setProcesedSize(getProcesedSize()+len);
                    setReaded(getReaded()+len);

                    long[] values = window.refreshGUI((Zipper) this);
                    setSpeedSize(values[0]);
                    setReaded(values[1]);
                    setTime(values[2]);

                }

                fos.close();
                ze = zis.getNextEntry();
            }

            zis.closeEntry();
            zis.close();

            window.getFrame().dispose();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
