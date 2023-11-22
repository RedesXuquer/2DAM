/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package examensql;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author denos
 */

/*

Al iniciar el programa se tiene que cargar en el textArea todo la información

Rúbrica

CRUD	1 punto cada método
listarEmpleados	1,5 punto
buscarEmpleadoPorNombre	1,5 punto
eliminarEmpleado: 	1,5 punto
Comentarios	1,5 punto

Base de datos -> EmpresaDB
Tabla -> Empleados

id (int, clave primaria)
nombre (varchar)
puesto (varchar)
salario (double)



*/
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextArea areaSalida;
    @FXML
    private TextField fieldId;
    @FXML
    private TextField fieldNombre;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonActionBorrar(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionFiltro(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionMostrarTodo(ActionEvent event) {
    }
    
}
