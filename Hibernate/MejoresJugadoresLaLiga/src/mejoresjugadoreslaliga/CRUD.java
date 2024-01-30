/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mejoresjugadoreslaliga;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author denos
 */
public class CRUD {
    
        Session session;
    
    void crearSession(){    
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(JugadoresPOJO.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.session = sessionFactory.openSession();
        this.session.beginTransaction();
    }

    public List<JugadoresPOJO> ListarTodo(){
        List<JugadoresPOJO> canciones = this.session.createQuery("from JugadoresPOJO", JugadoresPOJO.class).list();
        //this.session.close();
        return canciones;
    }
    
    void eliminarProducto(int id) {
        // Obtener el producto a eliminar
        JugadoresPOJO jugadorCRUDBorrar = this.session.get(JugadoresPOJO.class, id);

        // Eliminar el producto
        if (jugadorCRUDBorrar != null) {
            this.session.delete(jugadorCRUDBorrar);
        }
        this.session.getTransaction().commit();
        session.close();
    }
    
    void crearJugador(String nombre, String nombreEquipo, int goles, int golesEquipo, int contribucion) {
        //try (Session session = this.sessionFactory.openSession()) {
        
        JugadoresPOJO nuevo = new JugadoresPOJO();
        nuevo.setNombre(nombre);
        nuevo.setEwuipo(nombreEquipo);
        nuevo.setGolesJugador(goles);
        nuevo.setGolesEquipo(golesEquipo);
        nuevo.setContribucion(contribucion);

        this.session.save(nuevo);
        this.session.getTransaction().commit();     
        session.close();
    }
    
    void actualizarProducto(int id, String nombre, String equipo) {
            
            // Obtener el producto a actualizar
            JugadoresPOJO cambio = this.session.get(JugadoresPOJO.class, id);

            // Actualizar los campos
            if (cambio != null) {
                cambio.setNombre(nombre);
                cambio.setEwuipo(equipo);
            }
            this.session.getTransaction().commit();
        }
    }
   
    
