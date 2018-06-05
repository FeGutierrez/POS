/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgiraldo.fgutierrez.modelo;

import java.io.Serializable;

/**
 *
 * @author Flexxo333
 */
public class Producto implements Serializable{
    
    private String codigoBarras;
    private String nombre;
    private int cantidadEnStock;
    private double precio;

    public Producto(String codigoBarras, String nombre, double precio) {
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.cantidadEnStock = 0;
        this.precio = precio;
    }
    
    public String info(){
        return this.codigoBarras + " " + this.nombre + " " + 
                this.cantidadEnStock + " " +this.precio;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
