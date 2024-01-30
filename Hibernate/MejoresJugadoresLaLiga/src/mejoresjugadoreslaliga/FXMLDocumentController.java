/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package mejoresjugadoreslaliga;

import com.sun.org.apache.bcel.internal.generic.IFEQ;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author denos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField fieldPosicion;
    @FXML
    private TextField fieldNombreJugador;
    @FXML
    private TextField fieldEquipo;
    @FXML
    private TextField fieldGolesJugador;
    @FXML
    private TextField fieldGolesEquipo;
    @FXML
    private TextField fieldContribucion;
    @FXML
    private Button buttonAnterior;
    @FXML
    private Button buttonPosterior;
    @FXML
    private Button buttonGuardar;
    @FXML
    private Button buttonBuscar;
    @FXML
    private Button buttonEliminar;
    
    private void handleButtonAction(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CRUD jugadores = new CRUD();
        
        jugadores.crearSession();
        jugadores.actualizarProducto(5, "Pepe", "Familyy Cash");
        //jugadores.crearJugador("Luis Aleza Bargues", "Valencia CF", 10, 20, 30);
        //jugadores.crearSession();
        //List<JugadoresPOJO> listaJugadores = jugadores.ListarTodo();
        //System.out.println(listaJugadores.get(0).getNombre());
        //jugadores.eliminarProducto(listaJugadores.get(0).getId());
    }    

    @FXML
    private void handleButtonActionAnterior(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionPosterior(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionGuardar(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionBuscar(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionEliminar(ActionEvent event) {
    }
    
    
    
}
