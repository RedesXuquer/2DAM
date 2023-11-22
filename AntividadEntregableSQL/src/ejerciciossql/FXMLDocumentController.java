/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package ejerciciossql;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author denos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextArea areaOutput;
    @FXML
    private Button buttonActualizar;
    @FXML
    private TextField fieldId;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldCC;
    @FXML
    private TextField fieldDistrict;
    @FXML
    private TextField fieldPopulation;
    @FXML
    private Button buttonEliminar;
    
    ConexionSQL conexionBBDD;
    @FXML
    private TextField fieldPathCSV;
    @FXML
    private Button buttonCSVtoSQL;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        try {
            conexionBBDD = new ConexionSQL("world","root","");
            ResultSet resultado = conexionBBDD.Read("select * from city");
            /*
            // Procesar los resultados
            while (resultado.next()) {
                // Obtener valores de las columnas
                String valorColumna1 = resultado.getString("Id");
                String valorColumna2 = resultado.getString("Name");
                String valorColumna3 = resultado.getString("CountryCode");
                String valorColumna4 = resultado.getString("District");
                String valorColumna5 = resultado.getString("Population");

                // Hacer algo con los valores obtenidos (imprimirlos en este ejemplo)
                areaOutput.setText(areaOutput.getText() + "Columna1: " + valorColumna1 + ", Columna2: " + valorColumna2+ ", Columna3: " + valorColumna3+ ", Columna4: " + valorColumna4+ ", Columna5: " + valorColumna5+"\n");   
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }    

    @FXML
    private void handleButtonActionActualizar(ActionEvent event) throws SQLException {
        /*
        if (fieldId.getText().isEmpty()){
            conexionBBDD.Ejecutar(fieldName.getText(), fieldCC.getText(), fieldDistrict.getText(), fieldPopulation.getText());
        }
        else{
            conexionBBDD.Ejecutar(Integer.parseInt(fieldId.getText()),fieldName.getText(), fieldCC.getText(), fieldDistrict.getText(), fieldPopulation.getText());
        }*/
    }

    @FXML
    private void handleButtonActionBorrar(ActionEvent event) throws SQLException {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Vas a eliminar el registro con el ID: "+fieldId.getText());
        alert.setContentText("¿Estás seguro?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            conexionBBDD.Delete(Integer.parseInt(fieldId.getText()));
        }   
    }    

    @FXML
    private void handleButtonActionCSVtoSQL(ActionEvent event) throws IOException, SQLException {
        List<String> libroCompleto = null;
        LeerCSV leerArchivoCSV = new LeerCSV(fieldPathCSV.getText());
        libroCompleto = leerArchivoCSV.LeerLinea();
        
        ConexionSQL datosGuardar = new ConexionSQL("biblioteca","root","");
                
        while ((libroCompleto = leerArchivoCSV.LeerLinea())!=null){
            //System.out.println(libroCompleto.get(0));
            datosGuardar.Ejecutar(libroCompleto.get(0), libroCompleto.get(1), libroCompleto.get(2), libroCompleto.get(3), libroCompleto.get(4), libroCompleto.get(5));
        }
        
    }
}
