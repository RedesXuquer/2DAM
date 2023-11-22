/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package inicialsql;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private Button buttonRead;
    private TextArea AreaResult;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonCreate;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonCreateS;
    
    String BBDD = "world";
    String user = "root";
    String pass = "";
    @FXML
    private TextArea areaResult;
    @FXML
    private TextArea areaInput;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonActionRead(ActionEvent event) throws SQLException {
        
        ConexionSQL nuevaConexion = new ConexionSQL();
        
        nuevaConexion.nueva(BBDD, user, pass);
        
        ResultSet resultado = nuevaConexion.read(areaInput.getText());
        
        areaResult.setText("");
        
        // Procesar y mostrar los datos
        while (resultado.next()) {
            int id = resultado.getInt("id");
            String nombre = resultado.getString("Name");
            String CC = resultado.getString("CountryCode");
            String District = resultado.getString("District");
            String Population = resultado.getString("Population");
            
            // Puedes acceder a otras columnas de la tabla de la misma manera
            areaResult.setText(areaResult.getText()+"ID: " + String.valueOf(id)+" Nombre: " + nombre+" CC: " + CC+" District: " + District+" Population: " + Population+"\n");
        }
        nuevaConexion.finalizar();
    }

    @FXML
    private void handleButtonActionUpdate(ActionEvent event) throws SQLException {
        
        ConexionSQL nuevaConexion = new ConexionSQL();
        
        nuevaConexion.nueva(BBDD, user, pass);

        int resultado = nuevaConexion.CUD(areaInput.getText());
        
        if (resultado > 0) {
            areaInput.setText("Datos insertados con éxito.");
        } else {
            areaInput.setText("La inserción falló.");
        }       
        nuevaConexion.finalizar();
    }

    @FXML
    private void handleButtonActionCreate(ActionEvent event) throws SQLException {
        
        ConexionSQL nuevaConexion = new ConexionSQL();
        
        nuevaConexion.nueva(BBDD, user, pass);

        int resultado = nuevaConexion.CUD(areaInput.getText());
        
        if (resultado > 0) {
            areaInput.setText("Datos insertados con éxito.");
        } else {
            areaInput.setText("La inserción falló.");
        }
        nuevaConexion.finalizar();      
    }

    @FXML
    private void handleButtonActionDelete(ActionEvent event) throws SQLException {

        ConexionSQL nuevaConexion = new ConexionSQL();
        
        nuevaConexion.nueva(BBDD, user, pass);

        int resultado = nuevaConexion.CUD(areaInput.getText());
        
        if (resultado > 0) {
            areaInput.setText("Datos insertados con éxito.");
        } else {
            areaInput.setText("La inserción falló.");
        }
        nuevaConexion.finalizar();
    }

    @FXML
    private void handleButtonActionCreateS(ActionEvent event) throws SQLException {
        
        ConexionSQL nuevaConexion = new ConexionSQL();
        
        nuevaConexion.nueva(BBDD, user, pass);
        
        int resultado = nuevaConexion.createS("Alzira", "ESP", "Valencia", "50000");
        
        // Comprobar si la inserción fue exitosa
        if (resultado > 0) {
            areaInput.setText("Datos insertados con éxito.");
        } else {
            areaInput.setText("La inserción falló.");
        }    
        nuevaConexion.finalizar();
    }
}
