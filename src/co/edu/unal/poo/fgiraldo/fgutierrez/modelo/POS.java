/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgiraldo.fgutierrez.modelo;

import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.ProductAlreadyExistsException;
import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.SalesmanAlreadyExistsException;
import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.ExistentClientException;
import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Flexxo333
 */
public class POS implements Serializable{
    private String name;
    private ArrayList<Factura> facturasEmitidas;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Cajero> listaCajeros;
    private double iva;

    public POS(String name, double iva) {
        this.name = name;
        this.facturasEmitidas = new ArrayList<>();
        this.iva = iva;
        listaProductos = new ArrayList<>();
        listaClientes = new ArrayList<>();
        listaCajeros = new ArrayList<>(); 
    }
    
    public void crearProducto(String codigodeBarras, String nombre, double precio) throws ProductAlreadyExistsException{
       Producto producto = null;
        for (int i = 0; i < this.listaProductos.size(); i++) {
            if (this.listaProductos.get(i).getCodigoBarras().equals(codigodeBarras)) {
                producto = this.listaProductos.get(i);
            }
        }
        if (producto!=null) {
            throw new ProductAlreadyExistsException();
        } else {
            producto = new Producto(codigodeBarras, nombre, precio);
            this.listaProductos.add(producto);
        }
    }
    
    public void crearCliente(int cedula, String nombre, String direccion) throws ExistentClientException{
        Cliente cliente = null;
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getCedula() == cedula ) {
                cliente = this.listaClientes.get(i);
            }
        }
        if (cliente!=null) {
            throw new ExistentClientException();
        } else {
            cliente = new Cliente(direccion, cedula, nombre);
            this.listaClientes.add(cliente);
        }
    }
    
    public void crearCajero(int cedula, String nombre) throws SalesmanAlreadyExistsException{
        Cajero cajero =null;
        for (int i = 0; i < this.listaCajeros.size(); i++) {
            if (this.listaCajeros.get(i).getCedula() == cedula) {
                cajero = this.listaCajeros.get(i);
            }
        }
        if (cajero!=null) {
            throw new SalesmanAlreadyExistsException();
        } else {
            cajero = new Cajero(cedula, nombre);
            this.listaCajeros.add(cajero);
        }
    }
    
    
    public void crearFactura(int cedulaCliente, int cedulaCajero) throws ClientNotFoundException, SalesmanNotFoundException{
        Cliente cliente = null;
        Cajero cajero = null;
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).cedula == cedulaCliente) {
                cliente = this.listaClientes.get(i);
            }
        }
        for (int i = 0; i < this.listaCajeros.size(); i++) {
            if (this.listaCajeros.get(i).cedula == cedulaCajero) {
                cajero = this.listaCajeros.get(i);
            }
        }
        
        if (cliente == null) {
            throw new ClientNotFoundException();
        } else {
            if (cajero == null) {
                throw new SalesmanNotFoundException();
            } else {
                Factura factura = new Factura(cliente, cajero, this.name, this.iva);
                this.facturasEmitidas.add(factura);
                factura.setId(this.facturasEmitidas.size());
            }
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Factura> getFacturasEmitidas() {
        return facturasEmitidas;
    }

    public void setFacturasEmitidas(ArrayList<Factura> facturasEmitidas) {
        this.facturasEmitidas = facturasEmitidas;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Cajero> getListaCajeros() {
        return listaCajeros;
    }

    public void setListaCajeros(ArrayList<Cajero> listaCajeros) {
        this.listaCajeros = listaCajeros;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
    
    
    
    
}
