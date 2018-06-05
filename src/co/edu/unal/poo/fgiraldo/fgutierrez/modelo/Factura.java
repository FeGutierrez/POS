/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgiraldo.fgutierrez.modelo;

import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.AbsentSaleException;
import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.NotEnoughInStockException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Flexxo333
 */
public class Factura implements Serializable{
    private int id;
    private Cliente cliente;
    private Cajero cajero;
    private String informacionSupermercado;
    private ArrayList<Venta> listaVentas ; 
    private double subtotal;
    private double costoTotal;
    private int numeroArticulos;
    private double montoRecibido;
    private double cambioaEntregar;
    private double iva;

    public Factura(Cliente cliente, Cajero cajero, String 
            informacionSupermercado, double iva) {
        this.cliente = cliente;
        this.cajero = cajero;
        this.informacionSupermercado = informacionSupermercado;
        this.montoRecibido = 0;
        this.iva= iva;
        this.numeroArticulos = 0;
        this.cambioaEntregar = 0;
        this.costoTotal = 0.0;
        this.subtotal = 0.0;
    }
    
    public double calcularCostoTotal(){
        double x = this.subtotal + ((this.subtotal/100)*this.iva);
        return x;
    }
    
    public int calcularNumeroArticulos(){
        int sumatoria = 0;
        for (int i = 0; i < this.listaVentas.size(); i++) {
            sumatoria += this.listaVentas.get(i).getCantidad();
        }
        return sumatoria;
    }
    
    public double calcularCambioAEntregar(){
        return this.montoRecibido - this.costoTotal;
    }
    
    public void anadirVenta(Producto producto, int cantidad) throws NotEnoughInStockException, AbsentSaleException{
        Venta venta = null;
        if ((producto.getCantidadEnStock()-cantidad)<0 ) {
            throw new NotEnoughInStockException();
        } else {
            venta = new Venta(producto, cantidad);            
        }
        if (venta == null) {
            throw new AbsentSaleException();
        } else {
            this.listaVentas.add(venta);
            this.subtotal = this.calcularSubtotal();
            this.costoTotal = this.calcularCostoTotal();
            this.numeroArticulos = this.calcularNumeroArticulos();
            this.cambioaEntregar = this.calcularCambioAEntregar();
        }
    }
    
    public double calcularSubtotal(){
        int sumatoria = 0;
        for (int i = 0; i < this.listaVentas.size(); i++) {
            sumatoria += this.listaVentas.get(i).subtotalVenta();
        }
        return sumatoria;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public String getInformacionSupermercado() {
        return informacionSupermercado;
    }

    public void setInformacionSupermercado(String informacionSupermercado) {
        this.informacionSupermercado = informacionSupermercado;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public int getNumeroArticulos() {
        return numeroArticulos;
    }

    public void setNumeroArticulos(int numeroArticulos) {
        this.numeroArticulos = numeroArticulos;
    }

    public double getMontoRecibido() {
        return montoRecibido;
    }

    public void setMontoRecibido(double montoRecibido) {
        this.montoRecibido = montoRecibido;
    }

    public double getCambioaEntregar() {
        return cambioaEntregar;
    }

    public void setCambioaEntregar(double cambioaEntregar) {
        this.cambioaEntregar = cambioaEntregar;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
