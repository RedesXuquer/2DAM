/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creationhibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author denos
 */
public class crudHibernate {
    Configuration configuration;
    SessionFactory sessionFactory;
    
    SessionFactory crearSession(){
        
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory; 
    }
    
    public List<Song> ListarTodo(SessionFactory sessionFactory){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            return session.createQuery("from Song", Song.class).list();
        }
    }
}
