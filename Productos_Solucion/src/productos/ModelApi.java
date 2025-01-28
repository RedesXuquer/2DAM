/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

/**
 *
 * @author denos
 */
public class ModelApi {
    
    public JsonArray leerApi(String urlAPI){
        JsonArray jsonArray = null;
            try {
            // URL de la API (ejemplo, ajusta según el endpoint necesario)
            //String  = "https://fakestoreapi.com/products";
            
            // Crear conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) new URL(urlAPI).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36");
            
            ModelHibernate mHibernate = new ModelHibernate();
            mHibernate.crearSession();
            
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

                jsonArray = JsonParser.parseString(response.toString()).getAsJsonArray();
            } else {
                System.out.println("Error en la solicitud. Código de respuesta: " + responseCode);
            }
                connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return jsonArray;
            
    }
   /* 
    public void mostratTodoAPI(){
        
                
                for (JsonElement element : this.jsonArray) {
                    JsonObject jsonObject = element.getAsJsonObject();
                    
                    // Acceder a los campos del objeto
                    int id = jsonObject.get("id").getAsInt();
                    String title = jsonObject.get("title").getAsString();
                    double price = jsonObject.get("price").getAsDouble();
                    String description = jsonObject.get("description").getAsString();              

                    //mHibernate.insertarProductos(title, price, description);
                    
                            // Mostrar la información
                            System.out.println("ID: " + id);
                            System.out.println("Título: " + title);
                            System.out.println("Precio: " + price);
                            System.out.println("Descripción: " + description);
                            System.out.println();
                        
        
    }
    
    
}*/
    
}
