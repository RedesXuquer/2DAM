/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication38;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import org.hibernate.Transaction;


/**
 *
 * @author denos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Configurar la sesión de Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Abrir una sesión de Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Iniciar una transacción
            session.beginTransaction();

            // Realizar la consulta para obtener todos los usuarios
            List<Song> usuarios = session.createQuery("from Song", Song.class).getResultList();

            // Imprimir la información de los usuarios
            for (Song usuario : usuarios) {
                System.out.println("ID: " + usuario.getId() + ", Canción: " + usuario.getSongName() + ", Artista: " + usuario.getArtist());
            }

            // Commit de la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar la sesión de Hibernate
            sessionFactory.close();
        }
    }
}        
        // TODO
        /*
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        // Initialize Session Object
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        
//Get Example
        try{
            Song song1 = (Song) session.get(Song.class, new Integer(1));
            System.out.println("Song get called");
            if(song1 != null){
                System.out.println("Song GET ID= "+song1.getId());
                System.out.println("Song Get Details:: "+song1.getArtist()+"\n");
                System.out.println("Song Get Details:: "+song1.getSongName()+"\n");
            }
        }catch(Exception e){
                e.printStackTrace();
        }        
        
        
        
        /*
        Song song1 = new Song();
        
         song1.setId(1);
        song1.setSongName("Broken Angel");
        song1.setArtist("Akon");
 
        session.beginTransaction();
 
        // Here we have used
        // save() method of JPA
        session.save(song1);
        */
        //session.getTransaction().commit();
        

