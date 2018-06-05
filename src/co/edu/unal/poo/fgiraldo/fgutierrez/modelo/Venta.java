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
public class Venta implements Serializable{
    
    private Producto producto;
    private int cantidad;

    public Venta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        producto.setCantidadEnStock(producto.getCantidadEnStock()-cantidad);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double subtotalVenta(){
        return (this.producto.getPrecio())*this.cantidad;
    }
    
    
    
    
}
