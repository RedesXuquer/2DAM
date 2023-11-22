/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
        try {
            LeerFichero leerfichero = new LeerFichero("datos.conf");
            fieldServer.setText(leerfichero.leerLinea());
            fieldUser.setText(leerfichero.leerLinea());
            fieldPass.setText(leerfichero.leerLinea());
            fieldDatabase.setText(leerfichero.leerLinea());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfiguracionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfiguracionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void OnActionGuardar(ActionEvent event) throws IOException {
        
        EscribirFichero escribirFichero = new EscribirFichero("datos.conf");
        escribirFichero.Escribir(fieldServer.getText()+"\n");
        escribirFichero.Escribir(fieldUser.getText()+"\n");
        escribirFichero.Escribir(fieldPass.getText()+"\n");
        escribirFichero.Escribir(fieldDatabase.getText());
        escribirFichero.Cerrar();
    }

    
}
