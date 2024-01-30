/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudmongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

/**
 *
 * @author denos
 */
public class CRUD {

    public static void update(String dbName, String collectionName, String fieldName, Object fieldValue, Object newFieldValue){
        
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // Selecciona la base de datos
            MongoDatabase database = mongoClient.getDatabase(dbName);

            // Selecciona la colección
            MongoCollection<Document> collection = database.getCollection(collectionName);

            // Crea un documento de filtro para encontrar el documento a actualizar
            Document filter = new Document(fieldName, fieldValue);

            // Crea un documento de actualización para especificar los cambios
            Document update = new Document("$set", new Document(fieldName, newFieldValue));

            // Realiza la operación de actualización y obtén el resultado
            UpdateResult result = collection.updateOne(filter, update);

            // Imprime el resultado de la operación
            System.out.println("Documentos afectados: " + result.getModifiedCount());

        } catch (Exception e) {
            System.err.println("Error de conexión o actualización: " + e.getMessage());
        }
        
    }
    
    
    public static void create(){
        String connectionString = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Selecciona la base de datos
            MongoDatabase database = mongoClient.getDatabase("prueba");

            // Selecciona la colección
            MongoCollection<Document> collection = database.getCollection("cancion");

            // Crea un nuevo documento a ser insertado
            Document document = new Document("name", "Adiós")
                    .append("age", 33)
                    .append("city", "Jerusalem")
                    .append("country", "Israel");
            // Inserta el documento en la colección
            collection.insertOne(document);

            System.out.println("Documento insertado correctamente.");

        } catch (Exception e) {
            System.err.println("Error de conexión o inserción: " + e.getMessage());
        }
    }
    
    public static void read(){
        String connectionString = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Selecciona la base de datos
            MongoDatabase database = mongoClient.getDatabase("prueba");

            // Selecciona la colección
            MongoCollection<Document> collection = database.getCollection("cancion");

            // Realiza una operación de lectura (en este caso, encuentra todos los documentos)
            FindIterable<Document> documents = collection.find();

            // Itera sobre los documentos y muestra la información
            try (MongoCursor<Document> cursor = documents.iterator()) {
                while (cursor.hasNext()) {
                    Document document = cursor.next();
                    System.out.println(document.toJson());
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error de conexión o lectura: " + e.getMessage());
        }      
    }
    
    public static void delete(String dbName, String collectionName, String fieldName, Object fieldValue){

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // Selecciona la base de datos
            MongoDatabase database = mongoClient.getDatabase(dbName);

            // Selecciona la colección
            MongoCollection<Document> collection = database.getCollection(collectionName);

            // Crea un documento de filtro para encontrar el documento a eliminar
            Document filter = new Document(fieldName, fieldValue);

            // Realiza la operación de eliminación y obtén el resultado
            DeleteResult result = collection.deleteOne(filter);

            // Imprime el resultado de la operación
            System.out.println("Documentos afectados: " + result.getDeletedCount());

        } catch (Exception e) {
            System.err.println("Error de conexión o eliminación: " + e.getMessage());
        }        
    }
    
}
