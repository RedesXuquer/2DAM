/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author denos
 */


@Entity
// Seleccionamos el nombre de la tabla
@Table(name = "producto")

public class Producto {

        
    // Indicamos el tipo ID y le marcamos el nombre de la columna, en este caso songId. Después le marcamos el tipo de dato, en este caso **int** y el nombre de la variable id.
    @Id @Column(name = "id") private int id;

    // Indicamos el nombre de la segunda columna **songName**. Después le marcamos el tipo de dato, en este caso **String** y el nombre de la variable songName.
    @Column(name = "nombre") private String nombre;
 
    // Indicamos el nombre de la tercera columna **singer**. Después le marcamos el tipo de dato, en este caso **String** y el nombre de la variable artist.
    @Column(name = "precio") private Double precio;

    // Indicamos el nombre de la tercera columna **singer**. Después le marcamos el tipo de dato, en este caso **String** y el nombre de la variable artist.
    @Column(name = "categoria") private String categoria;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
