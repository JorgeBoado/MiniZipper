package com.minizipper.unzip;

import com.minizipper.gui.VentanaProgreso;
import com.minizipper.zipper.Zipper;

import javax.swing.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class UnZip extends Zipper {
    private String inputZipFile;
    private String outputFolder;
    private VentanaProgreso window;

    private UnZip(String source) {
        inputZipFile = source;
        outputFolder = source.substring(0, source.lastIndexOf("\\"));
    }

    public static void unZip(String source) {
        if (source == null) {
            return;
        }
        UnZip unZip = new UnZip(source);
        unZip.start();
    }

    @Override
    public void run() {
        window = new VentanaProgreso();
        window.getFrame().setTitle("Comprimiendo: " + inputZipFile + " en " + outputFolder + " . . .");
        setListeners();
        window.getFrame().setVisible(true);
        long totalSize = 0;
        try (ZipFile zf = new ZipFile(inputZipFile)) {

            Enumeration zes = zf.entries();
            while(zes.hasMoreElements()){
                ZipEntry ze = (ZipEntry) zes.nextElement();
                totalSize+=ze.getSize();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        setTotalSize(totalSize);
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

            ZipFile zf = new ZipFile(zipFile);
            InputStream zis = new InputStream() {
                @Override
                public int read() throws IOException {
                    return 0;
                }
            };
            Enumeration zipEntries = zf.entries();

            while(zipEntries.hasMoreElements()){
                ZipEntry ze = (ZipEntry) zipEntries.nextElement();
                zis = zf.getInputStream(ze);
                //System.out.println(ze.getName()+" --- "+ze.getCompressedSize()+" --- "+ze.getSize());

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

                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);

                    setProcesedSize(getProcesedSize()+len);
                    setReaded(getReaded()+len);

                    long[] values = window.refreshGUI(this);
                    setSpeedSize(values[0]);
                    setReaded(values[1]);
                    setTime(values[2]);
                }

                fos.close();
            }
            zis.close();

            window.getFrame().dispose();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
