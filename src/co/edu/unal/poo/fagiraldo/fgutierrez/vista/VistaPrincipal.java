/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrez.vista;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Flexxo333
 */
public class VistaPrincipal {
    
    private Scene scene;
    private BorderPane bpane1;
    private HBox hboxTop;
    private VBox vboxleft;
    private GridPane gridCenter;
    
    //Top
    private Label labeltop;
    //Left
    private Button irFacturaButton;
    private Button anadirVentaButton;
    private Button pushFacturaButton;
    
    
    //Pane crear Factura
    //int cedulaCliente, int cedulaCajero, double montoRecibido
    private Button crearFacturaButton;
    private GridPane gpanecrearFactura;
    private ChoiceBox cedulaClienteFactura;
    private ChoiceBox cedulaCajeroFactura;
    private TextField montoRecibidoFactura;
    private Label msgCrearFactura;
            
            

    public VistaPrincipal() {
        bpane1 = new BorderPane();
        
        labeltop = new Label("Ventas");
        hboxTop = new HBox(labeltop);
        
        bpane1.setTop(hboxTop);
        
        irFacturaButton = new Button("Crear Factura");
        vboxleft = new VBox(irFacturaButton);
        
        //GridCenter
        
            //Labels
        Label label1 = new Label("Elegir Cliente");
        Label label2 = new Label("Elegir Cajero");
        Label label3 = new Label("Monto Recibido");
        
        
        gpanecrearFactura = new GridPane();
        cedulaClienteFactura = new ChoiceBox();
        cedulaCajeroFactura = new ChoiceBox();
        montoRecibidoFactura = new TextField();
        
        VBox vboxgridCenter1 = new VBox(label1, cedulaClienteFactura);
        VBox vboxgridCenter2 = new VBox(label2, cedulaCajeroFactura);
        VBox vboxgridCenter3 = new VBox(label3, montoRecibidoFactura);
        crearFacturaButton = new Button("Crear Factura");
        msgCrearFactura = new Label("");
        
        gpanecrearFactura.add(vboxgridCenter1, 0, 0);
        gpanecrearFactura.add(vboxgridCenter2, 1, 0);
        gpanecrearFactura.add(vboxgridCenter3, 2, 0);
        gpanecrearFactura.setHgap(30);
        gpanecrearFactura.setVgap(15);
        gpanecrearFactura.setPadding(new Insets(10, 10, 10, 60));
        gpanecrearFactura.add(crearFacturaButton, 0, 1);
        gpanecrearFactura.add(msgCrearFactura, 1, 2);
        
        bpane1.setLeft(vboxleft);
        bpane1.setPadding(new Insets(20, 20, 10, 40));
        scene = new Scene(bpane1, 1200, 800);   
    }
    
    public void setPaneG(GridPane pane){
        this.bpane1.setCenter(pane);
    }
    
    public void show(Stage stage){
      stage.setTitle("Principal Ventas");
      stage.setScene(scene);
      stage.show();
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public BorderPane getBpane1() {
        return bpane1;
    }

    public void setBpane1(BorderPane bpane1) {
        this.bpane1 = bpane1;
    }

    public HBox getHboxTop() {
        return hboxTop;
    }

    public void setHboxTop(HBox hboxTop) {
        this.hboxTop = hboxTop;
    }

    public VBox getVboxleft() {
        return vboxleft;
    }

    public void setVboxleft(VBox vboxleft) {
        this.vboxleft = vboxleft;
    }

    public GridPane getGridCenter() {
        return gridCenter;
    }

    public void setGridCenter(GridPane gridCenter) {
        this.gridCenter = gridCenter;
    }

    public Label getLabeltop() {
        return labeltop;
    }

    public void setLabeltop(Label labeltop) {
        this.labeltop = labeltop;
    }

    public Button getCrearFacturaButton() {
        return crearFacturaButton;
    }

    public void setCrearFacturaButton(Button crearFacturaButton) {
        this.crearFacturaButton = crearFacturaButton;
    }

    public Button getAnadirVentaButton() {
        return anadirVentaButton;
    }

    public void setAnadirVentaButton(Button anadirVentaButton) {
        this.anadirVentaButton = anadirVentaButton;
    }

    public Button getPushFacturaButton() {
        return pushFacturaButton;
    }

    public void setPushFacturaButton(Button pushFacturaButton) {
        this.pushFacturaButton = pushFacturaButton;
    }

    public GridPane getGpanecrearFactura() {
        return gpanecrearFactura;
    }

    public void setGpanecrearFactura(GridPane gpanecrearFactura) {
        this.gpanecrearFactura = gpanecrearFactura;
    }

    public ChoiceBox getCedulaClienteFactura() {
        return cedulaClienteFactura;
    }

    public void setCedulaClienteFactura(ChoiceBox cedulaClienteFactura) {
        this.cedulaClienteFactura = cedulaClienteFactura;
    }

    public ChoiceBox getCedulaCajeroFactura() {
        return cedulaCajeroFactura;
    }

    public void setCedulaCajeroFactura(ChoiceBox cedulaCajeroFactura) {
        this.cedulaCajeroFactura = cedulaCajeroFactura;
    }

    public TextField getMontoRecibidoFactura() {
        return montoRecibidoFactura;
    }

    public void setMontoRecibidoFactura(TextField montoRecibidoFactura) {
        this.montoRecibidoFactura = montoRecibidoFactura;
    }

    public Button getIrFacturaButton() {
        return irFacturaButton;
    }

    public void setIrFacturaButton(Button irFacturaButton) {
        this.irFacturaButton = irFacturaButton;
    }

    public Label getMsgCrearFactura() {
        return msgCrearFactura;
    }

    public void setMsgCrearFactura(Label msgCrearFactura) {
        this.msgCrearFactura = msgCrearFactura;
    }
    
    
    
}
