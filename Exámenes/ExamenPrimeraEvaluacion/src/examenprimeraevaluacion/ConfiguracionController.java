/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package examenprimeraevaluacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author denos
 */
public class ConfiguracionController implements Initializable {

    @FXML
    private TextField fieldServer;
    @FXML
    private TextField fieldUser;
    @FXML
    private TextField fieldPass;
    @FXML
    private TextField fieldDatabase;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Crear la clase y métodos necesarios
        
        // Cargar el contenido del archivo TXT y rellenar los campos
        
    }    

    @FXML
    private void OnActionGuardar(ActionEvent event) {
        // Crear la clase y métodos necesarios
        
        // Guardar todos los campos en el archivo TXT
        
        // ** Muy importante **
        // Los datos de la conexión solo se deben cargar al iniciar el programa
        // Aquí SOLO se guardar en el TXT
        // ** Muy importante **
        
    }
    
}
