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
public abstract class Persona implements Serializable{
    protected int cedula;
    protected String nombre;

    public Persona(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    
    public String info(){
        return this.cedula + " " + this.nombre;
    }
    
    
}
