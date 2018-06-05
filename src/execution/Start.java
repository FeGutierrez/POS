/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execution;

/**
 *
 * @author Flexxo333
 */

import co.edu.unal.poo.fagiraldo.fgutierrez.controladores.VistaPrincipalVC;
import co.edu.unal.poo.fgiraldo.fgutierrez.modelo.DataBean;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author Flexxo333
 */
public class Start extends Application{

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        DataBean dataBean = new DataBean(primaryStage);
        VistaPrincipalVC principalVC = new VistaPrincipalVC(dataBean);
        principalVC.show();
    }
}