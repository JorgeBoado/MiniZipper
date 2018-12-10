package com.minizipper.zip;

import com.minizipper.gui.VentanaProgreso;
import com.minizipper.zipper.Zipper;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip extends Zipper {

    private List<String> fileList;
    private String outputZipFile;
    private String sourceFolder;
    private VentanaProgreso window;

    private Zip(String source) {
        fileList = new ArrayList<>();
        sourceFolder = source;
        outputZipFile = source.concat(".zip");
    }

    public static void zip(String source) {
        if (source == null) {
            return;
        }
        Zip appZip = new Zip(source);
        appZip.start();
    }

    @Override
    public void run() {
        window = new VentanaProgreso();
        window.getFrame().setTitle("Comprimiendo: " + sourceFolder + " en " + outputZipFile + " . . .");
        setListeners();
        window.getFrame().setVisible(true);
        generateFileList(new File(sourceFolder));
        zipIt(outputZipFile);
    }

    private void setListeners(){

        window.getBtnCancelar().addActionListener(e -> {
            int confirm;
            setWait(true);
            confirm = JOptionPane.showConfirmDialog (window.getFrame(), "¿Estas seguro de que deseas cancelar la compresion?","Cancelar",JOptionPane.YES_NO_OPTION);
            if(confirm==0){
                setCancel(true);
                window.getFrame().dispose();
            }
            setWait(false);
        });
    }

    private void generateFileList(File node) {
        // add file only
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.toString()));
            setTotalSize(getTotalSize()+node.length());
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                generateFileList(new File(node, filename));
            }
        }
    }

    private String generateZipEntry(String file) {
        return file.substring(sourceFolder.length() + 1, file.length());
    }

    private void zipIt(String zipFile) {

        setTime(new Timestamp(System.currentTimeMillis()).getTime() / 100);

        byte[] buffer = new byte[1024];
        String source = new File(sourceFolder).getName();
        //fos = null;
        //zos = null;
        try(FileOutputStream fos = new FileOutputStream(zipFile); ZipOutputStream zos = new ZipOutputStream(fos)) {
            //System.out.println("Output to Zip : " + zipFile);

            for (String file : this.fileList) {
                if(isCancel()) {break;}
                //System.out.println("File Added : " + file);
                window.getTxtCurrentFile().setText(file);
                ZipEntry ze = new ZipEntry(source + File.separator + file);
                zos.putNextEntry(ze);
                try (FileInputStream in = new FileInputStream(sourceFolder + File.separator + file)) {
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        while (isWait()) {
                            System.out.print("");
                        }
                        if (isCancel()) {
                            break;
                        }
                        zos.write(buffer, 0, len);
                        setProcesedSize(getProcesedSize()+len);
                        setReaded(getReaded()+len);

                        long[] values = window.refreshGUI((Zipper) this);
                        setSpeedSize(values[0]);
                        setReaded(values[1]);
                        setTime(values[2]);
                    }
                }
                zos.closeEntry();
            }



            //System.out.println("Folder successfully compressed");
            window.getFrame().dispose();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (isCancel()){
            File delFile = new File(outputZipFile);
            delFile.delete();
        }
    }



}

