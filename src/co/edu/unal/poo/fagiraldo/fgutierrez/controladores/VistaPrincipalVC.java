/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrez.controladores;

import co.edu.unal.poo.fagiraldo.fgutierrez.vista.VistaPrincipal;
import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.ClientNotFoundException;
import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.SalesmanNotFoundException;
import co.edu.unal.poo.fgiraldo.fgutierrez.modelo.Cajero;
import co.edu.unal.poo.fgiraldo.fgutierrez.modelo.Cliente;
import co.edu.unal.poo.fgiraldo.fgutierrez.modelo.DataBean;
import co.edu.unal.poo.fgiraldo.fgutierrez.modelo.Factura;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Flexxo333
 */
public class VistaPrincipalVC {
    private DataBean databean;
    private VistaPrincipal view;

    public VistaPrincipalVC(DataBean databean) {
        this.databean = databean;
        this.view = new VistaPrincipal();
        view.getIrFacturaButton().setOnAction(new cargarGridRegistroHandler());
        view.getCrearFacturaButton().setOnAction(new createFacturaHandler());
        view.getCedulaClienteFactura();
        view.getCedulaCajeroFactura();
    }
    
    public void show(){
        view.show(databean.getPrimaryStage());
    }
    
    class cargarGridRegistroHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent e){
            ObservableList<Cliente> clientes = FXCollections.observableArrayList(
                    databean.getPos().getListaClientes()
            );
            ObservableList<Cajero> cajeros = FXCollections.observableArrayList(
                    databean.getPos().getListaCajeros()
            );
            view.getCedulaClienteFactura().setItems(clientes);
            view.getCedulaCajeroFactura().setItems(cajeros);
            view.setPaneG(view.getGpanecrearFactura());
	}
    }
    
    class createFacturaHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent e){
            Cajero cajero = (Cajero)view.getCedulaCajeroFactura().getValue();
            Cliente cliente = (Cliente) view.getCedulaClienteFactura().getValue();
            int cedulaCliente = cliente.getCedula();
            int cedulaCajero = cajero.getCedula();
            //Double.parseDouble(view.getMontoRecibidoFactura().getText())
            try {
                databean.getPos().crearFactura(cedulaCliente, cedulaCajero);
                view.getMsgCrearFactura().setText("Exitoso");
            } catch (ClientNotFoundException | SalesmanNotFoundException ex) {
                view.getMsgCrearFactura().setText(ex.getMessage());
            }
            //view.getGpanecrearFactura().add(child, cedulaCajero, cedulaCajero);
            
            
	}
    }
    
}
