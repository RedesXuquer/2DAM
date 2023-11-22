/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package repasoxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author denos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField fieldID;
    @FXML
    private TextField fieldDNI;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldCalification;
    @FXML
    private Button buttonNext;
    @FXML
    private Button buttonPrevious;
    
    Integer position;
    
    ApoyoXML datos = new ApoyoXML();
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        position = 0;
        
        
        try {
            datos.LeerXML("datos.xml");
            
            NotasPOJO NotaInicial = new NotasPOJO();
            NotaInicial=datos.Read(0);
            fieldID.setText(String.valueOf(NotaInicial.getID()));
            fieldDNI.setText(NotaInicial.getDNI());
            fieldName.setText(NotaInicial.getNombre());
            fieldCalification.setText(String.valueOf(NotaInicial.getNota()));
            
        } catch (SAXException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            datos.EscribirXML("hola.xml");
        } catch (TransformerException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void handleButtonActionNext(ActionEvent event) {
        position++;
        
        if(position==datos.registros()){
            fieldID.setText("");
            fieldDNI.setText("");
            fieldName.setText("");
            fieldCalification.setText("");            
        }
        else{
            datos.Read(position);
        }
    }

    @FXML
    private void handleButtonActionPrevios(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionCreate(ActionEvent event) {
        
        String DNI = fieldDNI.getText();
        String nombre = fieldName.getText();
        Double nota = Double.valueOf(fieldCalification.getText());
        datos.Create(DNI, nombre, nota);
        
    }

    @FXML
    private void handleButtonActionDelete(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionUpdate(ActionEvent event) {
    }
 

    
}
