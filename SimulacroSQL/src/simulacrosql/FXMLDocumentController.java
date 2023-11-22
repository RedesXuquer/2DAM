/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package simulacrosql;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author denos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button buttonAnyadir;
    @FXML
    private TextArea areaSalida;
    @FXML
    private Button buttonEliminar;
    @FXML
    private Button buttonInsertar;
    @FXML
    private Button buttonMostrar;
    @FXML
    private TextArea areaEntrada;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonActionAnyadir(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionEliminar(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionInsertar(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionMostrar(ActionEvent event) {
    }
    
}
