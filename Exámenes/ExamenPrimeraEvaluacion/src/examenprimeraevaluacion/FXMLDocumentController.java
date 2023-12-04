/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package examenprimeraevaluacion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author denos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button buttonConfiguracion;
    @FXML
    private TextField fieldTitulo;
    @FXML
    private TextField fieldDescripcion;
    @FXML
    private TextField fieldFecha;
    @FXML
    private Button buttonAnotar;
    @FXML
    private TextField fieldHecha;
    @FXML
    private TextArea areaAnotaciones;
    @FXML
    private Button buttonHecha;
    @FXML
    private TextArea areaXML;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Crear la clase y métodos necesarios
        // Al abrir la aplicación se tiene que:
        // - Leer de datosConf.txt toda la información necesaria para crear la conexión de MySQL
        // - Todas las anotaciones disponibles que haya en MySQL en TextArea con nombre areaAnotaciones;
        // - Se tiene que cargar el archivo festivos.xml y mostrarlos en el TextArea con nombre areaXML;
        //   - root: festivos
        //   - nodo: festivo
        //   - elemento: fecha
        
    }    

    @FXML
    private void handleButtonActionConfiguracion(ActionEvent event) throws IOException {
        
        //Instrucciones en el Controler de Configuación
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Configuracion.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleButtonActionAnotar(ActionEvent event) {
        // Crear la clase y métodos necesarios
        // Se tiene que crear una anotación nueva y mostrar en el TextArea con nombre areaAnotaciones;
        
    }

    @FXML
    private void handleButtonActionHecha(ActionEvent event) {
        // Crear la clase y métodos necesarios
        // Se tiene que eliminar la anotación y quitar del TextArea con nombre areaAnotaciones;
        
    }
    
}
