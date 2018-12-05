package com.minizipper.zip;

import com.minizipper.gui.VentanaComThread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    //TODO Quitar estaticos
    private static String outputZipFile = "Folder.zip";
    private static String sourceFolder = "D:\\c";
    private VentanaComThread window;
    private long folderSize = 0;
    private long procesedSize = 0;

    private Zip() {
        fileList = new ArrayList<>();
    }

    public static void zip(String source) {
        sourceFolder = source;
        outputZipFile = source + ".zip";
        outputZipFile = source.concat(".zip");

        Zip appZip = new Zip();
        appZip.start();
    }

    private void zipIt(String zipFile) {

        byte[] buffer = new byte[1024];
        String source = new File(sourceFolder).getName();
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(fos);

            System.out.println("Output to Zip : " + zipFile);
            FileInputStream in = null;

            for (String file : this.fileList) {
                System.out.println("File Added : " + file);
                window.getTxtCurrentFile().setText(file);
                ZipEntry ze = new ZipEntry(source + File.separator + file);
                zos.putNextEntry(ze);
                try {
                    in = new FileInputStream(sourceFolder + File.separator + file);
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                        procesedSize+=len;
                        window.getComProBar().setValue((int)((procesedSize*100)/folderSize));
                    }
                } finally {

                    in.close();
                }
            }

            zos.closeEntry();
            System.out.println("Folder successfully compressed");
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
    }

    private void generateFileList(File node) {
        // add file only
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.toString()));
            folderSize+=node.length();
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
        window.getFrame().setVisible(true);
        generateFileList(new File(sourceFolder));
        zipIt(outputZipFile);
    }

    private void setListeners(){

        window.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Añadir evento de cancelar
            }
        });
    }

}

