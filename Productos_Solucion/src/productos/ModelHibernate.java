/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author denos
 */
public class ModelHibernate {
        //SessionFactory sessionFactory;
    Session session;
    Transaction transaction;
    /*
    public void cerrarSession(){
        this.sessionFactory.close();
    }*/
    
    public void crearSession(){

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Producto.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.session = sessionFactory.openSession();
        transaction = this.session.beginTransaction();
        //session.getTransaction().commit();
            // Cerrar la sesión de Hibernate
    }
    public void cerrarSession(){
        // Realiza commit para confirmar la transacción
        this.session.getTransaction().commit();
        //this.session.getTransaction().commit();
        this.session.close();
        
    }
        //session.getTransaction().commit();
            // Cerrar la sesión de Hibernate
    
    
    public void mostrarTodo(){
        
        List<Producto> productos = this.session.createQuery("from Producto", Producto.class).getResultList();
        System.out.println("***********************************");
        for (Producto articulo: productos){
            System.out.println(articulo.getNombre());
        }
    }
    
    public void insertarProductos(String nombre, Double precio, String categoria){
        //this.session.beginTransaction();
    // Intenta abrir una sesión utilizando la fábrica de sesiones existente
        //try (Session session = this.sessionFactory.openSession()) {
        // Inicia una transacción en la sesión
        //session.beginTransaction();

        // Crea una nueva instancia de la clase Song y establece sus propiedades
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setPrecio(precio);
        nuevoProducto.setCategoria(categoria);

        // Guarda la nueva instancia de Song en la base de datos
        this.session.save(nuevoProducto);
        this.session.flush();
        this.session.clear();
    }
}
