/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execution;

import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.ExistentClientException;
import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.ProductAlreadyExistsException;
import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.SalesmanAlreadyExistsException;
import co.edu.unal.poo.fgiraldo.fgutierrez.modelo.POS;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Flexxo333
 */
public class Initialize {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        
        
        File archivo = new File("POS_File_data.txt");
        if (!archivo.exists()) {
            try{
                archivo.createNewFile();
                System.out.println("Archivo creado");
            }catch (IOException ex){
                System.out.println("Archivo ya existe");
            }
        }
        
        
        ObjectOutputStream output= null;
        ObjectInputStream input= null;
        POS pos2 = null;
        int choice=0;
        POS pos = new POS("Point Of Sales", 19);
        
        
        
        try {
            pos.crearProducto("ABCDE456", "Avena Quaker", 1800);
            pos.crearProducto("XYZ123", "Paños Humedos", 3000);
            pos.crearProducto("QWERTY951", "Bombas marca ACME", 50000);
            pos.crearCliente(123, "Diana", "Cruz");
            pos.crearCliente(456, "Natalia", "Londoño");
            pos.crearCliente(789, "Susana", "Robledo");
            pos.crearCajero(321, "Camila");
            pos.crearCajero(654, "Alejandro");
            pos.crearCajero(987, "Daniela");
        } catch (ProductAlreadyExistsException | ExistentClientException | SalesmanAlreadyExistsException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (choice!= 10) {   
        System.out.println("Digite eleccion (1) Enviar objeto o 2) Leer Objeto"
                + "3) Listar Cajeros 4) Listar Clientes 5)Listar Productos");
        Scanner sc = new Scanner(System.in);
        choice=sc.nextInt();
        
            if (choice==1) {
                    output = new ObjectOutputStream(new FileOutputStream(archivo));
                    output.writeObject(pos);
            }
            if (choice==2) {
                    input = new ObjectInputStream(new FileInputStream(archivo));
                    pos2 = (POS) input.readObject();
                    pos = pos2;
                    
            }
            if (choice == 3) {
                for (int i = 0; i < pos.getListaCajeros().size(); i++) {
                    System.out.println(pos.getListaCajeros().get(i).info());
                }
            }
            if (choice == 4) {
                for (int i = 0; i < pos.getListaClientes().size(); i++) {
                    System.out.println(pos.getListaClientes().get(i).info());
                }
            }
            if (choice == 5) {
                for (int i = 0; i < pos.getListaProductos().size(); i++) {
                    System.out.println(pos.getListaProductos().get(i).info());
                }
            }
        }
        
    }
    
}
