/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package leergoku;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author denos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
         try {
            // URL de la API (ejemplo, ajusta según el endpoint necesario)
            String url = "https://dragonball-api.com/api/characters";
            
            // Crear conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            
            // Verificar respuesta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer respuesta
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                // Mostrar respuesta
                System.out.println("Respuesta de la API:");
                System.out.println(response.toString());

                
                
                
                JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
                
                //JsonArray itemsArray = jsonObject.getAsJsonArray("items");
                
                // JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();

                // Extraer los valores y mostrarlos
                int id = jsonObject.get("id").getAsInt();
                String name = jsonObject.get("name").getAsString();
                String ki = jsonObject.get("ki").getAsString();
                String maxKi = jsonObject.get("maxKi").getAsString();

                // Imprimir los valores
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + name);
                System.out.println("Ki: " + ki);
                System.out.println("Max Ki: " + maxKi);
                /*
                for (JsonElement element : itemsArray) {
                    JsonObject character = element.getAsJsonObject();
                    // Imprimir los datos del personaje
                    System.out.println("ID: " + character.get("id").getAsInt());
                    System.out.println("Nombre: " + character.get("name").getAsString());
                    System.out.println("Ki: " + character.get("ki").getAsString());
                    System.out.println("Max Ki: " + character.get("maxKi").getAsString());
                    System.out.println("Raza: " + character.get("race").getAsString());
                    System.out.println("Género: " + character.get("gender").getAsString());
                    System.out.println("Descripción: " + character.get("description").getAsString());
                    System.out.println("Imagen: " + character.get("image").getAsString());
                    System.out.println("Afiliación: " + character.get("affiliation").getAsString());
                    System.out.println("----------------------------");
                    }    */
                } else {
                    System.out.println("Error en la solicitud. Código de respuesta: " + responseCode);
                }
                connection.disconnect();                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
