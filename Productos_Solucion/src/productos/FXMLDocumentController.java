/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package productos;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author denos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button buttonPrevio;
    @FXML
    private TextField InputId;
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputPrice;
    @FXML
    private TextField inputCategory;
    @FXML
    private Button buttonSiguiente;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonListAll;
    @FXML
    private Button buttonDelete;
    
    private void handleButtonAction(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //https://fakestoreapi.com/products
        
        ModelApi mAPI = new ModelApi();
        JsonArray jsonArray = mAPI.leerApi("https://fakestoreapi.com/products");
        
        ModelHibernate mHibernate = new ModelHibernate();
        mHibernate.crearSession();
        for (JsonElement element : jsonArray) {
            JsonObject jsonObject = element.getAsJsonObject();
                    
            // Acceder a los campos del objeto
            int id = jsonObject.get("id").getAsInt();
            String title = jsonObject.get("title").getAsString();
            double price = jsonObject.get("price").getAsDouble();
            String description = jsonObject.get("description").getAsString();              

            // Mostrar la información
            System.out.println("ID: " + id);
            System.out.println("Título: " + title);
            System.out.println("Precio: " + price);
            System.out.println("Descripción: " + description);
            System.out.println();            
            
            mHibernate.insertarProductos(title, price, description);

        }
        mHibernate.cerrarSession();
    }

    @FXML
    private void handleButtonListAll(ActionEvent event) {
        ModelHibernate mHibernate = new ModelHibernate();
        mHibernate.crearSession();
        mHibernate.mostrarTodo();
        mHibernate.crearSession();
    }

    @FXML
    private void handleButtonUpdate(ActionEvent event) throws SQLException {
        
        ModelSQL actualizar = new ModelSQL("examen_programacion","root","");
        actualizar.Actualizar(Integer.parseInt(InputId.getText()), "HolaMundo", 100.00, "HolaMundo");
        
        
    }

    @FXML
    private void handleButtonDelete(ActionEvent event) throws SQLException {
        ModelSQL actualizar = new ModelSQL("examen_programacion","root","");
        actualizar.Delete(Integer.parseInt(InputId.getText()));
    }   
}
