package com.minizipper.zip;

import com.minizipper.gui.VentanaComThread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zip extends Thread{

    private List<String> fileList;
    private String outputZipFile;
    private String sourceFolder;
    private VentanaComThread window;
    private long totalSize = 0;
    private long procesedSize = 0;
    private long speedSize = 0;
    private boolean cancel = false;
    private boolean wait = false;

    private Zip(String source) {
        fileList = new ArrayList<>();
        sourceFolder = source;
        outputZipFile = source + ".zip";
        outputZipFile = source.concat(".zip");
    }

    public static void zip(String source) {
        Zip appZip = new Zip(source);
        appZip.start();
    }

    private void zipIt(String zipFile) {

        long time = new Timestamp(System.currentTimeMillis()).getTime()/100;
        long readed = 0;

        byte[] buffer = new byte[1024];
        String source = new File(sourceFolder).getName();
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(fos);

            //System.out.println("Output to Zip : " + zipFile);
            FileInputStream in = null;

            for (String file : this.fileList) {
                if(cancel) {break;}
                //System.out.println("File Added : " + file);
                window.getTxtCurrentFile().setText(file);
                ZipEntry ze = new ZipEntry(source + File.separator + file);
                zos.putNextEntry(ze);
                try {
                    in = new FileInputStream(sourceFolder + File.separator + file);
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        while(wait){
                            System.out.print("");
                        }
                        if(cancel){break;}
                        zos.write(buffer, 0, len);
                        procesedSize+=len;
                        readed+=len;

                        if((new Timestamp(System.currentTimeMillis()).getTime()/1000)!=time/10){
                            speedSize = (speedSize+readed)/2;
                            readed=0;
                        }

                        if((new Timestamp(System.currentTimeMillis()).getTime()/100)!=time){
                            updateGUI();
                            time=new Timestamp(System.currentTimeMillis()).getTime()/100;
                        }

                    }
                } finally {
                    in.close();
                }
            }

            zos.closeEntry();
            //System.out.println("Folder successfully compressed");
            window.getFrame().dispose();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                zos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (cancel){
            File delFile = new File(outputZipFile);
            delFile.delete();
        }

    }

    private void generateFileList(File node) {
        // add file only
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.toString()));
            totalSize +=node.length();
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

    @Override
    public void run() {
        window = new VentanaComThread();
        setListeners();
        window.getFrame().setVisible(true);
        generateFileList(new File(sourceFolder));
        zipIt(outputZipFile);
    }

    private void setListeners(){

        window.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm;
                wait = true;
                confirm = JOptionPane.showConfirmDialog (window.getFrame(), "¿Estas seguro de que deseas cancelar la compresion?","Cancelar",JOptionPane.YES_NO_OPTION);
                if(confirm==0){
                    cancel = true;
                    window.getFrame().dispose();
                }
                wait = false;
            }
        });
    }

    private String toSizeUnit(long length, boolean hasUnit){

        double size = (double)length/1024;
        String[] unit = {" Kb", " Mb", " Gb"};

        int x=0;
        for(;size/1024>1; x++){
            size = size/1024;
        }

        return hasUnit ? (new DecimalFormat("#.##").format(size) + unit[x]) : (new DecimalFormat("#.##").format(size));
    }

    private void updateGUI(){
        window.getComProBar().setValue((int)((procesedSize*100)/ totalSize));
        window.getTxtComSize().setText("Total: \t"+toSizeUnit(procesedSize, true)+" / "+toSizeUnit(totalSize, true));
        window.getTxtComSpeed().setText("Velocidad: \t"+toSizeUnit(speedSize, true)+"/s");
    }

}

