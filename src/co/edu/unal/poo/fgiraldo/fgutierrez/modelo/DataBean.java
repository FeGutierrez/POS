/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgiraldo.fgutierrez.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;

/**
 *
 * @author Flexxo333
 */
public class DataBean {
    
    private Stage primaryStage=null;
    private POS pos;
    File archivo;
    
    ObjectOutputStream output= null;
    ObjectInputStream input= null;
    FileInputStream in = null;
    POS pos2 = null;
    
    public DataBean(Stage primaryStage) {
        this.archivo = new File("POS_File_data.txt");
        this.primaryStage = primaryStage;
        if (!this.archivo.exists()) {
            try {
                if (this.archivo.createNewFile()) {
                    System.out.println("Archivo creado");
                }
            } catch (IOException ex) {
                System.out.println("Prohibido crear el archivo");
            }
        }
        try {
            input = new ObjectInputStream(new FileInputStream(this.archivo));
        } catch (IOException ex) {
            Logger.getLogger(DataBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pos2 = (POS) input.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DataBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.pos = pos2;
    }
    
    public void writeFile(){
        try {
            output = new ObjectOutputStream(
                    new FileOutputStream(this.archivo));
            output.writeObject(this.pos);
        } catch (IOException ex) {
            Logger.getLogger(
                    DataBean.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public POS getPos() {
        return pos;
    }
    
}
